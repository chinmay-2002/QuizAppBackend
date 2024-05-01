package com.chinmay.quizApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.chinmay.quizApp.model.Questions;
import com.chinmay.quizApp.repository.QuestionsRepository;

@Service
public class QuestionsServiceImpl implements QuestionsService{
	
	
	@Autowired
	private QuestionsRepository questionsRepository;
	

	@Override
	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		System.out.println(questionsRepository.findAll());
		return questionsRepository.findAll();
	}


	@Override
	public List<Questions> getAllQuestionsByCategory(String category) {
		// TODO Auto-generated method stub
		return questionsRepository.findByCategory(category);
	}


	@Override
	public Questions addQuestion(Questions question) {
		System.out.println("Adding Question  " + question);
		return questionsRepository.save(question);
	}


	@Override
	public void deleteQuestion(long id) {
		 questionsRepository.deleteById(id);
		
	}
	




}
