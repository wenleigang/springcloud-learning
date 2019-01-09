package com.chaosquark.springcloudkafka.kafka;

import com.chaosquark.springcloudkafka.entity.Message;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class KafkaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private Gson gson = new GsonBuilder().create();

    public void send(Long i) {
        Message message = new Message();
        message.setId(i);
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(new Date());
        log.info("========发送消息  "+i+" >>>>{}<<<<<==========",gson.toJson(message));
        kafkaTemplate.send("msg", gson.toJson(message));
    }
}
