package com.klef.jfsd.springboot.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Update;

public interface UpdateRepository extends JpaRepository<Update, String> {
	
	@Query("SELECT u FROM Update u WHERE u.areaconstituency = ?1 OR u.areaconstituency = ?2")
	public List<Update> findByAssemblyOrParilement(String assembly,String parilement);
}
