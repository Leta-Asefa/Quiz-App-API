package com.Leta.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Leta.DAO.QuestionDAO;
import com.Leta.DAO.QuizDAO;
import com.Leta.Model.Question;
import com.Leta.Model.QuestionWrapper;
import com.Leta.Model.Quiz;
import com.Leta.Model.Response;

@Service
public class QuizService {

	@Autowired
	QuestionDAO question_dao;
	@Autowired
	QuizDAO quiz_dao;
	
	public void create(String category, String title,Integer num) {
		Quiz quiz=new Quiz();
		quiz.setQuestions(question_dao.createQuiz(category,num));	
		quiz.setTitle(title);
		
		quiz_dao.save(quiz);
	}

	public ResponseEntity<List<Quiz>> getAll() {
		
	return	new ResponseEntity<>(quiz_dao.findAll(),HttpStatus.OK);
		
	}

	public List<QuestionWrapper> getById(Integer id) {
		List<Object[]> objects= quiz_dao.getQuestionWrapperById(id);
		List<QuestionWrapper> wrapper=new ArrayList<>();
		
		for(int i=0;i<5;i++) {
		wrapper.add(	new QuestionWrapper( (Long) objects.get(i)[5], (String)objects.get(i)[4],(String)objects.get(i)[0]  , 
					(String) objects.get(i)[1],(String)objects.get(i)[2], (String)objects.get(i)[3] ));
		
		}
		 
		return wrapper;
		}

	public Integer getResult(Long id, List<Response> responses) {
		
		Quiz quiz=quiz_dao.findById(id).get();
		List<Question> questions=quiz.getQuestions();
		
		int counter=0;
		int right=0;
		
		
		
		for (Response response : responses) {
			
			if(response.getAnswer().equals(questions.get(counter).getRightAnswer()))
			right++;
			counter++;
		}
		
		return right;
	}

	
	
	
	
	
}
