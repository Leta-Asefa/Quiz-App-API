package com.Leta.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Leta.Model.Question;


public interface QuestionDAO extends JpaRepository<Question, Long> {

	List<Question> findByCategory(String category);
	
	@Query(value="SELECT * FROM quizapp.question where category=:category order by rand() limit :num",nativeQuery=true)
	List<Question> createQuiz(@Param("category") String category,@Param("num") Integer num);

}
