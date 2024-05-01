package com.chinmay.quizApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chinmay.quizApp.model.Questions;



public interface QuestionsRepository extends JpaRepository<Questions, Long> {

	List<Questions> findByCategory(String category);

}
