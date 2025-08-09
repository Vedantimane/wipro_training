package com.learning.producer.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.learning.producer.dto.LearningProducerDTO;
import com.learning.producer.service.LearningProducerService;

@Service
public class LearningProducerServiceImp implements LearningProducerService {

//    @Autowired
//    private KafkaTemplate<String, LearningProducerDTO> kafkaTemplate; 
//    private KafkaTemplate<String, String> kafkaTemplate; 
//
//    private static final String TOPIC = "learning-topic"; 
//
//    @Override
//    public void sendLearningdata(String learningCode, String learningCourse) {
//        kafkaTemplate.send(TOPIC, learningCourse); 
//        System.out.println("✅ Sent message to Kafka: " + learningCourse);
//    }
	
	 @Autowired
	    private KafkaTemplate<String, Object> kafkaTemplate;

	    private static final String TOPIC = "learning-topic";

	    @Override
	    public void sendLearningdata(LearningProducerDTO dto) {
	        kafkaTemplate.send(TOPIC, dto);
	        System.out.println("✅ Sent message to Kafka: " + dto);
	    }
}
