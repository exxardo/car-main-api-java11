package com.carservice.carmainapi.message;

import com.carservice.carmainapi.dto.CarPostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * Classe responsável por produzir mensagens no tópico Kafka.
 * Envia dados de carros para o tópico Kafka configurado.
 */
@Component
public class KafkaProducerMassage {

    @Autowired
    private KafkaTemplate<String, CarPostDto> kafkaTemplate;

    private final String KAFKA_TOPIC = "car-post-topic"; // Nome do tópico Kafka para publicação.

    /**
     * Envia uma mensagem contendo os dados do carro para o tópico Kafka.
     *
     * @param carPostDto Objeto contendo os dados do carro a serem enviados.
     */
    public void sendMessage(CarPostDto carPostDto) {
        kafkaTemplate.send(KAFKA_TOPIC, carPostDto); // Publica a mensagem no tópico.
    }
}

