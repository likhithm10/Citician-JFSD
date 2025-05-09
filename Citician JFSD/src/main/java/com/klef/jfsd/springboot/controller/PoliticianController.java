package com.klef.jfsd.springboot.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.springboot.model.Citizen;
import com.klef.jfsd.springboot.model.Feedback;
import com.klef.jfsd.springboot.model.Issue;
import com.klef.jfsd.springboot.model.Politician;
import com.klef.jfsd.springboot.model.Update;
import com.klef.jfsd.springboot.service.PoliticianService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class PoliticianController 
{
	@Autowired
	private PoliticianService politicianService;
	
	
	
	@GetMapping("politicianhome")
	  public ModelAndView politicianhome()
	  {
	    ModelAndView mv=new ModelAndView("politicianhome");
	    return mv;
	  }
	
	@GetMapping("politicianlogin")
	public ModelAndView politicianLogin() 
	{
		ModelAndView mv=new ModelAndView();
	    mv.setViewName("politicianlogin");
	    return mv;
	}
	
	@PostMapping("checkPoliticianLogin")
	//@ResponseBody
	public ModelAndView checkPoliticianLogin(HttpServletRequest request) 
	{
		 ModelAndView mv = new ModelAndView();
		 String pidcode=request.getParameter("pidcode"); 
		 String ppassword= request.getParameter("ppassword"); 
		 Politician politician= politicianService.checkPoliticianLogin(pidcode, ppassword); 

	    if(politician!=null) {
	      //return "politician login success";
	      mv.setViewName("politicianhome");
	      HttpSession session = request.getSession();
	    	session.setAttribute("politician", politician);
	    }
	    else {
	      //return "politician login fail";
	      mv.setViewName("politicianlogin");
	      mv.addObject("message","Login Failed!");
	    }
	    return mv;
	  }
	
	@PostMapping("/addpolitician")
	public ModelAndView addPolitician(HttpServletRequest request) {
	    // Retrieving form data using getParameter
		String idCode = request.getParameter("idCode");
	    String fullName = request.getParameter("fullName");
	    String state = request.getParameter("state");
	    String mpMla = request.getParameter("mpmla");
	    String mobileNo = request.getParameter("mobileNo");
	    String assemblyparliament = request.getParameter("assemblyparliament");
	    String term = request.getParameter("term");
	    String password=idCode+state;

	    Politician politician = new Politician();
	    politician.setIdCode(idCode);
	    politician.setFullName(fullName);
	    politician.setState(state);
	    politician.setMpMla(mpMla);
	    politician.setMobileNo(mobileNo);
	    politician.setAssemblyparliament(assemblyparliament);
	    politician.setTerm(term);
	    politician.setPassword(password);

//	    try {
//	        // Handling file upload for the certificate image
//	        if (!certificateImage.isEmpty()) {
//	            politician.setCertificateImage(certificateImage.getBytes());
//	        }
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	        ModelAndView errorView = new ModelAndView("error-page");
//	        errorView.addObject("errorMessage", "Failed to upload the certificate image.");
//	        return errorView;
//	    }

	    // The password is auto-generated using the model logic

	    String msg = politicianService.AddPolitician(politician);

	    ModelAndView mv = new ModelAndView("addpolitician");
	    mv.addObject("message", msg);
	    return mv;
	}
	
	  @GetMapping("politicianprofile")
			public ModelAndView politicianprofile()
			{
			   ModelAndView mv=new ModelAndView("politicianprofile");
			   return mv;
			}
	  @GetMapping("postupdate")
		public ModelAndView postupdate()
		{
		   ModelAndView mv=new ModelAndView("postupdate");
		   return mv;
		}
	  @PostMapping("/addupdate")
	  public ModelAndView addfeedback(
	          HttpServletRequest request
	          ) {
		  HttpSession session = request.getSession();
	      session.getAttribute("politician");
	      Politician p =(Politician)session.getAttribute("politician");
	      String updateId = politicianService.updatecount();
	      String subject = request.getParameter("subject");
	      String mpmla = p.getMpmla();
	      String constituency = p.getAssemblyparliament();
	      String pid = p.getIdCode();
	      LocalDate date=LocalDate.now();
	      String update = request.getParameter("update");
	      String remarks = request.getParameter("remarks");
	      

	      Update updates = new Update();
	      updates.setUpdateId(updateId);
	      updates.setSubject(subject);
	      updates.setMpmla(mpmla);
	      updates.setAreaconstituency(constituency);
	      updates.setPoliticianid(pid);
	      updates.setDate(date);
	      updates.setUpdate(update);
	      updates.setRemarks(remarks);

	       politicianService.AddUpdate(updates);

	      ModelAndView mv = new ModelAndView("politicianhome");
	     
	      
	      return mv;
	  }
	  
	  @GetMapping("feedbackpage")
		public ModelAndView feedbackpage(HttpServletRequest request)
		{
		   ModelAndView mv=new ModelAndView("feedbackpage");
		   HttpSession session = request.getSession();
		      session.getAttribute("politician");
		      Politician p =(Politician)session.getAttribute("politician");
		      
		   List<Feedback> feeds = politicianService.viewfeedbackbyconstituency(p.getAssemblyparliament());
		    mv.addObject("feeds",feeds);
		   return mv;
		}
	  
	  @GetMapping("viewallcitizen")
		public ModelAndView viewallcitizen(HttpServletRequest request)
		{
		   ModelAndView mv=new ModelAndView("viewallcitizen");
		   HttpSession session = request.getSession();
		      session.getAttribute("politician");
		      Politician p =(Politician)session.getAttribute("politician");
		      
		   List<Citizen> citizens = politicianService.viewcitizensbyconstituency(p.getAssemblyparliament());
		    mv.addObject("citizens",citizens);
		   return mv;
		}
	  
	  @GetMapping("respond")
		public ModelAndView respond(HttpServletRequest request) 
		{
		  ModelAndView mv=new ModelAndView("respond");
		   HttpSession session = request.getSession();
		      session.getAttribute("politician");
		      Politician p =(Politician)session.getAttribute("politician");
		      
		   List<Issue> issues = politicianService.viewissuesbyconstituency(p.getAssemblyparliament());
		    mv.addObject("issues",issues);
		   return mv;
		}
	  
	  @PostMapping("/updateIssue")
	  public ModelAndView updateIssue(
	          HttpServletRequest request
	          ) {
	      String reportId = request.getParameter("reportId");
	      
	      String status = request.getParameter("status") ;
	      String remarks = request.getParameter("remarks");

	      Issue issues = new Issue();
	      issues.setReportId(reportId);
	     
	      issues.setStatus(status);
	      issues.setRemarks(remarks);

	       politicianService.updateIssue(issues);

	      ModelAndView mv = new ModelAndView("respond");
	      HttpSession session = request.getSession();
	      session.getAttribute("politician");
	      Politician p =(Politician)session.getAttribute("politician");
	      
	   List<Issue> issues1 = politicianService.viewissuesbyconstituency(p.getAssemblyparliament());
	    mv.addObject("issues",issues1);
	   return mv;
	      
	  }
		
}
