package com.learning.consumer.learningconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.learning.consumer.Learningconsumerdto.LearningConsumerDTO;

@Component
public class LearningConsumer {
	
//	@KafkaListener(topics = "learning-topic", groupId = "my-group-id")
//    public void consume(String msg) {
//        System.out.println("Consumed message: " + msg);
//    }

	@KafkaListener(topics = "learning-topic", groupId = "my-group-id")
    public void consume(LearningConsumerDTO dto) {
        System.out.println("Consumed message: " + dto);
    }

}
