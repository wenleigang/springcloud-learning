package com.chaosquark.springcloudkafka.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"msg"})
    public void consumer(ConsumerRecord<?, ?> consumerRecord) {
        Optional<? extends ConsumerRecord<?, ?>> record = Optional.ofNullable(consumerRecord);
        log.info(">>>>>>>>>> record =" + record);
        if(record.isPresent()) {
            ConsumerRecord<?, ?> record1 = record.get();
            log.info(">>>>>>>>接收消息message =" + record1);
        }
    }
}
