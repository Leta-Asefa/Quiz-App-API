package com.Leta.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leta.DAO.QuestionDAO;
import com.Leta.Model.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDAO dao;

	public   ResponseEntity<List<Question> >getAllQuestions() {
		try {
			
			return new ResponseEntity<>(dao.findAll(),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);

	}

	public List<Question> getQuestionsByCategory(String category) {
		
		return dao.findByCategory(category);
	}

	public ResponseEntity<String> add(Question question) {
		dao.save(question);
		return new ResponseEntity<>("added successfully  !",HttpStatus.CREATED);
		
	}

	public ResponseEntity<String> delete(Long id) {
		dao.deleteById(id);
		return new ResponseEntity<>("Deleted successfully ! ",HttpStatus.OK);
	}
	
}
