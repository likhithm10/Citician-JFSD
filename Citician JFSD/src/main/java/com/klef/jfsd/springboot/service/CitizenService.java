package com.klef.jfsd.springboot.service;

import java.util.List;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Update;

public interface CitizenService 
{
	public String CitizenRegistraion(Citizen c);
	public Citizen checkCitizenLogin(String epicCardNumber,String password);
	public String reportcount();
	public void AddIssue(Issue i);
	public List<Issue> viewissuebyepicid(String epicid);
	public String feedbackcount();
	public void AddFeedback(Feedback f);
	public List<Update> viewupdatesbyassemblyorparilement(String assembly,String parilement);
	public String UpdateCitizen(Citizen citizen);
	public Citizen displaycitizenbyId(String cid);
}
