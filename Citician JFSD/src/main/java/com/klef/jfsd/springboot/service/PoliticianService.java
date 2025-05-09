package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Update;

public interface PoliticianService 
{
	public String AddPolitician(Politician p);
	public Politician checkPoliticianLogin(String idCode,String password);
	public String updatecount();
	public void AddUpdate(Update u);
	
	public List<Feedback> viewfeedbackbyconstituency(String asspar);
	
	public List<Citizen> viewcitizensbyconstituency(String asspar);
	public List<Issue> viewissuesbyconstituency(String asspar);
	public void updateIssue(Issue i);
}
