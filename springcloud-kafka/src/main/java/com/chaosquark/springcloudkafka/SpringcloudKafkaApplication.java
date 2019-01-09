package com.chaosquark.springcloudkafka;

import com.chaosquark.springcloudkafka.kafka.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class SpringcloudKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudKafkaApplication.class, args);
    }

    @Autowired
    private KafkaSender kafkaSender;

    @PostConstruct
    public void init() {
        for (int i = 1; i < 10; i++) {
            kafkaSender.send((long)i);
        }
    }
}

