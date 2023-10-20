package com.Leta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Leta.Model.Question;
import com.Leta.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService service;

	@GetMapping("allQuestions")
	public ResponseEntity<List<Question> >getAllQuestions() {
		
		return service.getAllQuestions();
	}
	
	
	
	@GetMapping("category/{category}")
	public List<Question> getQuestionsByCategory(@PathVariable String category) {
		
		return service.getQuestionsByCategory(category);
	}
	
	@PostMapping("add")
	public ResponseEntity<String>   add(@RequestBody Question question)
	{
		return service.add(question);
		
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id)
	{
		return service.delete(id);
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
