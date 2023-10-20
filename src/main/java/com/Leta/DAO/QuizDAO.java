package com.Leta.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Leta.Model.Quiz;

public interface  QuizDAO extends JpaRepository<Quiz, Long> {

	@Query(value="select option1,option2,option3,option4,question_title,question.id from\r\n"
			+ "question join quiz_questions on question.id=quiz_questions.questions_id \r\n"
			+ "join quiz on quiz.id=quiz_questions.quiz_id where quiz.id=:id",nativeQuery=true)
	List<Object[]> getQuestionWrapperById(Integer id);
}
