package com.rca.issue.shopapp.controller;

import java.text.SimpleDateFormat;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rca.issue.shopapp.model.Application_Master;
import com.rca.issue.shopapp.model.Issue_Master;
import com.rca.issue.shopapp.repsitory.ApplicationRepository;
import com.rca.issue.shopapp.repsitory.EnvironmentRepository;
import com.rca.issue.shopapp.repsitory.RCARepository;
import com.rca.issue.shopapp.repsitory.StatusRepository;

@RestController
@RequestMapping(value = "/application-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class RCA_Controller {
	
	@Autowired
	private RCARepository rcaRepository;
	
	@Autowired
	private ApplicationRepository applicationRepository;
	
	@Autowired
	private EnvironmentRepository environmentRepository;
	
	@Autowired
	private StatusRepository statusRepository; 
	
	public ApplicationRepository getApplicationRepository() {
		return applicationRepository;
	}

	public void setApplicationRepository(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}

	public EnvironmentRepository getEnvironmentRepository() {
		return environmentRepository;
	}

	public void setEnvironmentRepository(EnvironmentRepository environmentRepository) {
		this.environmentRepository = environmentRepository;
	}

	public StatusRepository getStatusRepository() {
		return statusRepository;
	}

	public void setStatusRepository(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	public RCARepository getRcaRepository() {
		return rcaRepository;
	}

	public void setRcaRepository(RCARepository rcaRepository) {
		this.rcaRepository = rcaRepository;
	}

	@GetMapping(value = "/rcadashboard")
	public ModelAndView getRcaDashboard() {
		ModelAndView modelAndView = new ModelAndView();
		/* List recent 10 issues */
		modelAndView.getModelMap().put("RCAList", rcaRepository.findAll());
		modelAndView.setViewName("rcadashboard");
        return modelAndView;
    }

	@GetMapping(value = "/rca")
	public ModelAndView getRca() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("applicationList", applicationRepository.findAll());
		modelAndView.getModelMap().put("EnvironmentList", environmentRepository.findAll());
		modelAndView.getModelMap().put("StatusList", statusRepository.findAll());
		/* List recent 10 issues */
		modelAndView.getModelMap().put("action","new");
		modelAndView.getModelMap().put("rcaid","");
		modelAndView.setViewName("rca");
        return modelAndView;
    }
	
	@GetMapping(value = "/rca/{id}")
	public ModelAndView getRcaByID(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("applicationList", applicationRepository.findAll());
		modelAndView.getModelMap().put("EnvironmentList", environmentRepository.findAll());
		modelAndView.getModelMap().put("StatusList", statusRepository.findAll());
		/* List recent 10 issues */
		modelAndView.getModelMap().put("RCAdata", rcaRepository.findBymId(id));
		modelAndView.getModelMap().put("action","update");
		modelAndView.getModelMap().put("rcaid",id);
		modelAndView.setViewName("rca");
        return modelAndView;
    }
	
	@PostMapping("/rca")
	ModelAndView createOrSaveApplicationMaster(HttpServletRequest request) {
		try {
			Issue_Master im;
			if(request.getParameter("action").toString().equalsIgnoreCase("update")) {
				im=rcaRepository.getOne(Integer.parseInt(request.getParameter("rcaid").toString()));
			}
			else {
				im=new Issue_Master();
			}	
				
				im.setApplicationMaster(applicationRepository.findBymId(Integer.parseInt(request.getParameter(
						 "application").toString())));
				im.setEnvironmentMaster(environmentRepository.findBymId(Integer.parseInt(request.getParameter(
						 "environment").toString())));
				im.setIssueAPI(request.getParameter("issueInAPI").toString());
				im.setTitle(request.getParameter("issueTitle").toString());
				im.setDescription(request.getParameter("description").toString());
				im.setJira_imId(request.getParameter("im_jiraId").toString());
				im.setActionTaken(request.getParameter("actionTaken").toString());
				im.setStatusMaster(statusRepository.findBymId(Integer.parseInt(request.getParameter(
						 "status").toString())));
				im.setResolverGroup(request.getParameter("resolverGroup").toString());
				im.setReportedDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("reportedDate").toString()));
				im.setResolvedDate(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("resolvedDate").toString()));
				rcaRepository.save(im);
			

		} catch (Exception e) {
			System.out.println("Exception : "+e.getMessage());
		}
		
		return getRcaDashboard();
		
    }

}
