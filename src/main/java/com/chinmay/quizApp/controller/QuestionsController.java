package com.chinmay.quizApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chinmay.quizApp.model.Questions;
import com.chinmay.quizApp.service.QuestionsService;

@RestController
@RequestMapping("/questions")
public class QuestionsController {
	
	@Autowired
	private QuestionsService questionsService;
	
	
	
	@PostMapping("/addQuestion")
	public ResponseEntity<Questions> addQuestion (@RequestBody  Questions question){
		return new ResponseEntity<Questions>(questionsService.addQuestion(question),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		questionsService.deleteQuestion(id);
		
		return new ResponseEntity<String>("Question deleted successfully!.", HttpStatus.OK);
	}
	
	
	
	@GetMapping("/getallquestions")
    public List<Questions> getAllQuestions() {
        return questionsService.getAllQuestions();
    }
	
	@GetMapping("/{category}")
    public List<Questions> getAllQuestionsByCategory(@PathVariable String category) {
        return questionsService.getAllQuestionsByCategory(category);
    }
	
	
	
}
