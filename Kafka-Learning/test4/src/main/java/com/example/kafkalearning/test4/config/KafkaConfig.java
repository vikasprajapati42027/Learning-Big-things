package com.example.kafkalearning.test4.config;

import com.example.kafkalearning.test4.model.OrderEvent;
import com.example.kafkalearning.test4.service.OrderProcessingException;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.DeadLetterPublishingRecoverer;
import org.springframework.kafka.listener.DefaultErrorHandler;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.util.backoff.FixedBackOff;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {
    public static final String ORDER_TOPIC = "order-events";
    public static final String ARCHIVE_TOPIC = "order-events-archive";
    public static final String DLT_TOPIC = "order-events-dlt";

    @Bean
    public NewTopic orderTopic() {
        return TopicBuilder.name(ORDER_TOPIC)
                .partitions(6)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic archiveTopic() {
        return TopicBuilder.name(ARCHIVE_TOPIC)
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic dltTopic() {
        return TopicBuilder.name(DLT_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    @Bean
    public ProducerFactory<String, OrderEvent> producerFactory() {
        JsonSerializer<OrderEvent> serializer = new JsonSerializer<>();
        serializer.setAddTypeInfo(false);
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.ACKS_CONFIG, "all");
        props.put(ProducerConfig.ENABLE_IDEMPOTENCE_CONFIG, true);
        props.put(ProducerConfig.RETRIES_CONFIG, 10);
        props.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 1);
        props.put(ProducerConfig.LINGER_MS_CONFIG, 5);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, 32 * 1024);
        props.put(ProducerConfig.TRANSACTIONAL_ID_CONFIG, "order-pipeline-tx");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(props, new StringSerializer(), serializer);
    }

    @Bean
    public KafkaTemplate<String, OrderEvent> kafkaTemplate(ProducerFactory<String, OrderEvent> producerFactory) {
        KafkaTemplate<String, OrderEvent> template = new KafkaTemplate<>(producerFactory);
        template.setDefaultTopic(ORDER_TOPIC);
        return template;
    }

    @Bean
    public JsonDeserializer<OrderEvent> orderEventJsonDeserializer() {
        JsonDeserializer<OrderEvent> deserializer = new JsonDeserializer<>(OrderEvent.class);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(false);
        return deserializer;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, OrderEvent> kafkaListenerContainerFactory(
            JsonDeserializer<OrderEvent> deserializer,
            DefaultErrorHandler errorHandler) {
        Map<String, Object> props = consumerProperties();
        ConcurrentKafkaListenerContainerFactory<String, OrderEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new org.springframework.kafka.core.DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), deserializer));
        factory.setConcurrency(3);
        factory.getContainerProperties().setAckMode(org.springframework.kafka.listener.ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.setCommonErrorHandler(errorHandler);
        return factory;
    }

    private Map<String, Object> consumerProperties() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "order-consumers");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        return props;
    }

    @Bean
    public DeadLetterPublishingRecoverer recoverer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        return new DeadLetterPublishingRecoverer(kafkaTemplate, (record, ex) -> new org.apache.kafka.common.TopicPartition(DLT_TOPIC, record.partition()));
    }

    @Bean
    public DefaultErrorHandler errorHandler(DeadLetterPublishingRecoverer recoverer) {
        DefaultErrorHandler handler = new DefaultErrorHandler(recoverer, new FixedBackOff(2000L, 2));
        handler.addNotRetryableExceptions(OrderProcessingException.class);
        return handler;
    }
}
