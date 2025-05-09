package com.klef.jfsd.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, String> {
	
	@Query("select c from Citizen c where c.epicCardNumber=?1 and c.password=?2") 
	public Citizen checkCitizenLogin(String epicCardNumber, String password) ;
	
	@Query("SELECT c FROM Citizen c WHERE c.assembly = ?1 OR c.parliament = ?1")
	public List<Citizen> findcitizenbyAssPar(String asspar);
	
}
