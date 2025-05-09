package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;

public interface FeedbackRepository extends JpaRepository<Feedback, String> {
	
	@Query("SELECT f FROM Feedback f WHERE f.assembly = ?1 OR f.parliment = ?1")
	public List<Feedback> findByAssPar(String asspar);

}
