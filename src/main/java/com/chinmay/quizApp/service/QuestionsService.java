package com.chinmay.quizApp.service;

import java.util.List;

import com.chinmay.quizApp.model.Questions;


public interface QuestionsService {
	List<Questions> getAllQuestions();
	List<Questions> getAllQuestionsByCategory(String category);
	Questions addQuestion(Questions question);
	void deleteQuestion(long id);
}
