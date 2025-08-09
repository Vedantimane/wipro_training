package com.learning.producer.service;

import com.learning.producer.dto.LearningProducerDTO;

public interface LearningProducerService {

//	void sendLearningdata(String learningCode, String learningCourse);
	void sendLearningdata(LearningProducerDTO dto);
}
