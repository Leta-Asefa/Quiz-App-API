package com.Leta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Leta.Model.QuestionWrapper;
import com.Leta.Model.Quiz;
import com.Leta.Model.Response;
import com.Leta.Service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService service;
	
	@PostMapping("create")
	public String create(@RequestParam String category,@RequestParam String title,@RequestParam Integer num) {
		service.create(category,title,num);
		return "Success";
	}
	
	
	@GetMapping("getAll")
	public ResponseEntity<List<Quiz>>  getAll() {
		return service.getAll();
	}
	
	@GetMapping("get/{id}")
	public List<QuestionWrapper>  getById(@PathVariable Integer id) {
		return service.getById(id);
		
	} 
	
	@PostMapping("getResult/{id}")
	public Integer getResult(@PathVariable("id") Long id,@RequestBody List<Response> response) {
		return service.getResult(id,response);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
