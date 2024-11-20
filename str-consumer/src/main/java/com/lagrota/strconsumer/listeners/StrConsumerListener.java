package com.lagrota.strconsumer.listeners;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"0"})
            },
            containerFactory = "strContainerFactory")
    public void create(String message) {
        log.info("Create ::: Mensagem recebida: {}", message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"1"})
            },
            containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("Log ::: Mensagem recebida: {}", message);
    }

    @KafkaListener(groupId = "group-2   ", topics = "str-topic", containerFactory = "strContainerFactory")
    public void histor(String message) {
        log.info("History ::: Mensagem recebida: {}", message);
    }
}
