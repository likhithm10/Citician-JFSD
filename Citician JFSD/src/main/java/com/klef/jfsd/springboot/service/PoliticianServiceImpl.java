package com.klef.jfsd.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Update;
import com.klef.jfsd.springboot.repository.CitizenRepository;
import com.klef.jfsd.springboot.repository.FeedbackRepository;
import com.klef.jfsd.springboot.repository.IssueRepository;
import com.klef.jfsd.springboot.repository.PoliticianRepository;
import com.klef.jfsd.springboot.repository.UpdateRepository;

@Service
public class PoliticianServiceImpl implements PoliticianService
{
	@Autowired
	private PoliticianRepository politicianrepository;
	@Autowired
	private UpdateRepository updaterepository;
	@Autowired
	private FeedbackRepository feedbackrepository;
	@Autowired
	private IssueRepository issuerepository;
	@Autowired
	private CitizenRepository citizenrepository;
	
	@Override
	public String AddPolitician(Politician p) {
		politicianrepository.save(p);
		return "Politician Added Successfully";
	}

	@Override
	public Politician checkPoliticianLogin(String idCode, String password) {
		return politicianrepository.checkPoliticianLogin(idCode, password);

	}

	@Override
	public String updatecount() {
		long count = updaterepository.count(); // Count existing issues
        return "UP" + (count + 101);
	}

	@Override
	public void AddUpdate(Update u) {
		// TODO Auto-generated method stub
		updaterepository.save(u);
	}

	@Override
	public List<Feedback> viewfeedbackbyconstituency(String asspar) {
		// TODO Auto-generated method stub
		return feedbackrepository.findByAssPar(asspar);
	}

	@Override
	public List<Citizen> viewcitizensbyconstituency(String asspar) {
		// TODO Auto-generated method stub
		return citizenrepository.findcitizenbyAssPar(asspar);
	}

	@Override
	public List<Issue> viewissuesbyconstituency(String asspar) {
	    return issuerepository.findissuesbyAssPar(asspar, asspar);
	}

	@Override
	public void updateIssue(Issue i) {
		// TODO Auto-generated method stub
		issuerepository.updateIssue(i.getStatus(),i.getRemarks(),i.getReportId());
	}


}
