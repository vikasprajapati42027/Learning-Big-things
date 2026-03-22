package com.example.kafkalearning.test3.config;

import com.example.kafkalearning.test3.model.PaymentEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaTopicConfig {
    public static final String PAYMENTS_TOPIC = "payment-events";
    public static final String DLT_TOPIC = "payment-events-dlt";

    @Bean
    public NewTopic paymentsTopic() {
        return TopicBuilder.name(PAYMENTS_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic paymentsDltTopic() {
        return TopicBuilder.name(DLT_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public KafkaTemplate<String, PaymentEvent> paymentKafkaTemplate() {
        var configs = producerConfigs();
        var factory = new DefaultKafkaProducerFactory<>(configs);
        return new KafkaTemplate<>(factory);
    }

    private Map<String, Object> producerConfigs() {
        var props = new HashMap<String, Object>();
        props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

}
