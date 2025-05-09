package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Update;
import com.klef.jfsd.springboot.repository.CitizenRepository;
import com.klef.jfsd.springboot.repository.FeedbackRepository;
import com.klef.jfsd.springboot.repository.IssueRepository;
import com.klef.jfsd.springboot.repository.UpdateRepository;

@Service
public class CitizenServiceImpl implements CitizenService
{
	@Autowired
	private CitizenRepository citizenrepository;
	@Autowired
	private IssueRepository issuerepository;
	@Autowired
	private FeedbackRepository feedbackrepository;
	@Autowired
	private UpdateRepository updaterepository;

	@Override
	public String CitizenRegistraion(Citizen c) {
		citizenrepository.save(c);
		return "Citizen Registered Successfully" ;
	}

	@Override
	public Citizen checkCitizenLogin(String epicCardNumber, String password) {
		return citizenrepository.checkCitizenLogin(epicCardNumber, password);
	}

	@Override
	public String reportcount() {
		
		long count = issuerepository.count(); // Count existing issues
        return "TC" + (count + 101); 
	}

	@Override
	public void AddIssue(Issue i) {
		issuerepository.save(i);
		
	}

	@Override
	public List<Issue> viewissuebyepicid(String epicid) {
		// TODO Auto-generated method stub
		return issuerepository.findByEpicid(epicid);
	}

	@Override
	public String feedbackcount() {
		long count = feedbackrepository.count(); // Count existing issues
        return "FD" + (count + 101); 
	}

	@Override
	public void AddFeedback(Feedback f) {
		// TODO Auto-generated method stub
		feedbackrepository.save(f);
	}

	@Override
	public List<Update> viewupdatesbyassemblyorparilement(String assembly, String parilement) {
		// TODO Auto-generated method stub
		
		return updaterepository.findByAssemblyOrParilement(assembly,parilement);
	}
	@Override
	public String UpdateCitizen(Citizen citizen) {
		
		Citizen c = citizenrepository.findById(citizen.getEpicCardNumber()).get();
	    
	    c.setEpicCardNumber(citizen.getEpicCardNumber());
	    c.setFullName(citizen.getFullName());
	    c.setState(citizen.getState());
	    c.setAssembly(citizen.getAssembly());
	    c.setMobileNumber(citizen.getMobileNumber());
	    c.setParliament(citizen.getParliament());
	    c.setVillageCityTown(citizen.getVillageCityTown());
	    c.setPassword(citizen.getPassword());
	    
	    citizenrepository.save(c);
	    
	    return "Citizen Updated Successfully";
	}

	@Override
	public Citizen displaycitizenbyId(String cid) {
		
		return citizenrepository.findById(cid).get();
	}

}
