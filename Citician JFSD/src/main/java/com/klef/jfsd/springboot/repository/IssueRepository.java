package com.klef.jfsd.springboot.repository;


import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.klef.jfsd.springboot.model.Admin;
import com.klef.jfsd.springboot.model.Issue;

import jakarta.transaction.Transactional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, String>
{
	
	public List<Issue> findByEpicid(String epicid);
	@Query("SELECT i FROM Issue i WHERE i.assembly = ?1 OR i.parliment = ?2")
	public List<Issue> findissuesbyAssPar(String assembly, String parliment);
	@Query("UPDATE Issue i SET i.status = ?1, i.remarks = ?2 WHERE i.reportId = ?3")
	@Modifying  // DML
	@Transactional
	public void updateIssue(String status, String remarks, String reportId);



}
