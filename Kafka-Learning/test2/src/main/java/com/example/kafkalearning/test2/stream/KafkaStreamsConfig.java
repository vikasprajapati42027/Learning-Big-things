package com.example.kafkalearning.test2.stream;

import com.example.kafkalearning.test2.model.UserAction;
import com.example.kafkalearning.test2.model.UserActionCount;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.utils.Bytes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Grouped;
import org.apache.kafka.streams.kstream.KeyValue;
import org.apache.kafka.streams.kstream.Materialized;
import org.apache.kafka.streams.kstream.Produced;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.apache.kafka.streams.kstream.WindowStore;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;

@Configuration
public class KafkaStreamsConfig {
    private static final Logger log = LoggerFactory.getLogger(KafkaStreamsConfig.class);
    private static final String ACTIONS_TOPIC = "user-actions";
    private static final String COUNTS_TOPIC = "user-action-counts";

    @Bean
    public JsonSerde<UserAction> userActionSerde() {
        JsonSerde<UserAction> serde = new JsonSerde<>(UserAction.class);
        serde.configure(Collections.emptyMap(), false);
        return serde;
    }

    @Bean
    public JsonSerde<UserActionCount> userActionCountSerde() {
        JsonSerde<UserActionCount> serde = new JsonSerde<>(UserActionCount.class);
        serde.configure(Collections.emptyMap(), false);
        return serde;
    }

    @Bean
    public NewTopic userActionsTopic() {
        return TopicBuilder.name(ACTIONS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic userActionCountsTopic() {
        return TopicBuilder.name(COUNTS_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public KStream<String, UserAction> userActionStream(StreamsBuilder builder,
                                                        JsonSerde<UserAction> userActionSerde,
                                                        JsonSerde<UserActionCount> userActionCountSerde) {
        var windowSize = Duration.ofMinutes(1);
        var grace = Duration.ofSeconds(5);

        KStream<String, UserAction> userActions = builder.stream(ACTIONS_TOPIC, Consumed.with(Serdes.String(), userActionSerde));

        userActions
                .filter((key, action) -> action != null && action.getAction() != null && !action.getAction().isBlank())
                .peek((key, action) -> log.info("Received action {} for {}", action.getAction(), action.getUserId()))
                .map((key, action) -> KeyValue.pair(action.getAction().toUpperCase(), action))
                .groupByKey(Grouped.with(Serdes.String(), userActionSerde))
                .windowedBy(TimeWindows.ofSizeAndGrace(windowSize, grace))
                .count(Materialized.<String, Long, WindowStore<Bytes, byte[]>>as("user-action-count-store")
                        .withValueSerde(Serdes.Long()))
                .toStream()
                .map((windowedAction, count) -> KeyValue.pair(
                        windowedAction.key(),
                        new UserActionCount(
                                windowedAction.key(),
                                Instant.ofEpochMilli(windowedAction.window().start()),
                                Instant.ofEpochMilli(windowedAction.window().end()),
                                count)))
                .to(COUNTS_TOPIC, Produced.with(Serdes.String(), userActionCountSerde));

        return userActions;
    }
}
