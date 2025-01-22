package com.carservice.carmainapi.config;

import com.carservice.carmainapi.dto.CarPostDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuração para o produtor Kafka que envia mensagens relacionadas a CarPostDto.
 * Define as propriedades do produtor Kafka e inicializa os beans necessários para a comunicação.
 */
@Component
@Configuration
public class KafkaProducerConfig {

    // Obtém a URL do servidor Kafka a partir do arquivo de configuração (application.properties ou application.yml).
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    /**
     * Configura o ProducerFactory responsável por criar produtores Kafka.
     * Este método define as propriedades de configuração necessárias para a serialização de chaves e valores.
     *
     * @return ProducerFactory configurado para produzir mensagens do tipo String e CarPostDto.
     */
    @Bean
    public ProducerFactory<String, CarPostDto> userProducerFactory() {

        // Configurações para o produtor Kafka.
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer); // Servidor Kafka.
        configProps.put(JsonSerializer.ADD_TYPE_INFO_HEADERS, false); // Evita adicionar metadados extras no cabeçalho.
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // Serializador de chave.
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class.getName()); // Serializador de valor.

        return new DefaultKafkaProducerFactory<>(configProps);
    }

    /**
     * Configura o KafkaTemplate, que é usado para enviar mensagens para o Kafka.
     *
     * @return KafkaTemplate configurado para enviar mensagens do tipo String e CarPostDto.
     */
    @Bean
    public KafkaTemplate<String, CarPostDto> userKafkaTemplate() {
        return new KafkaTemplate<>(userProducerFactory());
    }
}
