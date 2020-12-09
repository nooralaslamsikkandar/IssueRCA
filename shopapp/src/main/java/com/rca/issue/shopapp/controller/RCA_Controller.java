package com.rca.issue.shopapp.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
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



	@GetMapping(value = "/rca")
	public ModelAndView getRca() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("applicationList", applicationRepository.findAll());
		modelAndView.getModelMap().put("EnvironmentList", environmentRepository.findAll());
		modelAndView.getModelMap().put("StatusList", statusRepository.findAll());
		/* List recent 10 issues */
		modelAndView.getModelMap().put("RCAList", rcaRepository.findAll());
		modelAndView.setViewName("rca");
        return modelAndView;
    }
	
	@PostMapping("/rca")
	void createOrSaveApplicationMaster(HttpServletRequest request) {
		
		Issue_Master im=new Issue_Master();
		
		im.setApplicationMaster(applicationRepository.findBymId(Integer.parseInt(request.getParameter(
				 "application").toString())));
		im.setEnvironmentMaster(environmentRepository.findBymId(Integer.parseInt(request.getParameter(
				 "environment").toString())));
		im.setStatusMaster(statusRepository.findBymId(Integer.parseInt(request.getParameter(
				 "status").toString())));
		im.setDescription(request.getParameter("description").toString());
		
		rcaRepository.save(im);
		
    }

}
