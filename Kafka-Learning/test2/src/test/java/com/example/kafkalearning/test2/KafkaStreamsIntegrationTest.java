package com.example.kafkalearning.test2;

import com.example.kafkalearning.test2.model.UserAction;
import com.example.kafkalearning.test2.model.UserActionCount;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(
        classes = KafkaStreamsApplication.class,
        properties = {
                "spring.kafka.bootstrap-servers=${spring.embedded.kafka.brokers}",
                "spring.kafka.streams.state-dir=${java.io.tmpdir}/kafka-streams-state-test"
        })
@EmbeddedKafka(partitions = 1, topics = {"user-actions", "user-action-counts"})
class KafkaStreamsIntegrationTest {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Autowired
    private KafkaTemplate<String, UserAction> kafkaTemplate;

    private KafkaConsumer<String, UserActionCount> consumer;

    @BeforeEach
    void setUpConsumer() {
        var props = KafkaTestUtils.consumerProps("test-consumer", "false", embeddedKafkaBroker);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        consumer = new KafkaConsumer<>(props, new StringDeserializer(), new JsonDeserializer<>(UserActionCount.class));
        consumer.subscribe(Collections.singletonList("user-action-counts"));
    }

    @AfterEach
    void tearDown() {
        if (consumer != null) {
            consumer.close();
        }
    }

    @Test
    void shouldAggregateUserActionsByWindow() {
        var action = new UserAction("alice", "login", Map.of("origin", "test"));

        kafkaTemplate.send("user-actions", action.getUserId(), action);
        kafkaTemplate.send("user-actions", action.getUserId(), action);
        kafkaTemplate.send("user-actions", "bob", new UserAction("bob", "login", Map.of()));

        ConsumerRecords<String, UserActionCount> records = KafkaTestUtils.getRecords(consumer, Duration.ofSeconds(30).toMillis());
        assertThat(records.isEmpty()).isFalse();

        Map<String, Long> counts = records.records("user-action-counts").stream()
                .collect(Collectors.groupingBy(
                        ConsumerRecord::key,
                        Collectors.mapping(r -> r.value().getCount(), Collectors.reducing(Long::max))))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().orElse(0L)));

        assertThat(counts.get("LOGIN")).isGreaterThanOrEqualTo(2L);
        assertThat(counts.values().stream().mapToLong(Long::longValue).sum()).isGreaterThanOrEqualTo(2L);
    }
}
