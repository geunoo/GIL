package com.example.kafka.config;

import com.example.kafka.domain.Feed;
import com.example.kafka.domain.User;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

    @Value(value = "${kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, User> userContainerFactory() {
        return createContainerFactory(User.class);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Feed> feedContainerFactory() {
        return createContainerFactory(Feed.class);
    }

    private <T> ConcurrentKafkaListenerContainerFactory<String, T> createContainerFactory(Class<T> type) {
        ConcurrentKafkaListenerContainerFactory<String, T> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(createKafkaConsumerFactory(type));
        return factory;
    }

    private <T> DefaultKafkaConsumerFactory<String, T> createKafkaConsumerFactory(Class<T> type) {
        JsonDeserializer<T> deserializer = createJsonDeserializer(type);
        return new DefaultKafkaConsumerFactory<>(
                createConsumerProps(deserializer.getClass()),
                new StringDeserializer(),
                deserializer
        );
    }

    private <T> Map<String, Object> createConsumerProps(Class<T> deserializerType) {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "foo");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, deserializerType);
        return props;
    }

    private <T> JsonDeserializer<T> createJsonDeserializer(Class<T> deserializedType) {
        JsonDeserializer<T> deserializer = new JsonDeserializer<>(deserializedType);
        deserializer.setRemoveTypeHeaders(false);
        deserializer.addTrustedPackages("*");
        deserializer.setUseTypeMapperForKey(true);
        return deserializer;
    }

}
