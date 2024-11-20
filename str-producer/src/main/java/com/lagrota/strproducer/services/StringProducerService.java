package com.lagrota.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {

        log.info("Iniciando envio da mensagem: {}", message);
        kafkaTemplate.send(
                "str-topic", // Nome do tópico
                message
        ).addCallback(
                success -> {
                    if (success != null) {
                        log.info("Mensagem enviada com sucesso: {}", message);
                        log.info("Partition: {}", success.getRecordMetadata().partition());
                        log.info("Offset: {}", success.getRecordMetadata().offset());
                    }
                },
                error -> log.error("Erro no envio da mensagem: {}", error.getMessage())
        );
    }
}
