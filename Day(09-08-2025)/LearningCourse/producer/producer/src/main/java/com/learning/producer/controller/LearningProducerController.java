package com.learning.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learning.producer.dto.LearningProducerDTO;
import com.learning.producer.service.LearningProducerService;

@RestController
@RequestMapping("/learning")
public class LearningProducerController {
	
	@Autowired
	LearningProducerService learningProducerService;
	
//	@PostMapping
//	void sendLearningData(@RequestParam String LearningCode,@RequestParam String LearningCourse) {
//		learningProducerService.sendLearningdata(LearningCode, LearningCourse);
//	}
	
	@PostMapping
	void sendLearningData(@RequestBody LearningProducerDTO dto) {
		learningProducerService.sendLearningdata(dto);
	}

}
