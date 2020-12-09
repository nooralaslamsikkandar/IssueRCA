package com.rca.issue.shopapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rca.issue.shopapp.model.Application_Master;
import com.rca.issue.shopapp.model.Environment_Master;
import com.rca.issue.shopapp.repsitory.ApplicationRepository;

@RestController
@RequestMapping(value = "/application-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ApplicationMaster {
	
	@Autowired
	private ApplicationRepository applicationRepository;

	public ApplicationRepository getApplicationRepository() {
		return applicationRepository;
	}

	public void setApplicationRepository(ApplicationRepository applicationRepository) {
		this.applicationRepository = applicationRepository;
	}
	
	@GetMapping(value = "/application")
	public ModelAndView getAllApplicationMasters() {
		//return applicationRepository.findAll();
		if(applicationRepository.findAll().size()>0) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterList", applicationRepository.findAll());
		modelAndView.getModelMap().put("master", "application");
		modelAndView.setViewName("master");
		 return modelAndView;
		}else
		{
			return addApplicationMasters();
		}
    }
	@GetMapping(value = "/application/add")
	public ModelAndView addApplicationMasters() {
        //return environmentRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterList", "add");
		modelAndView.getModelMap().put("master", "application");
		modelAndView.getModelMap().put("master_action", "new");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
	@PostMapping("/application")
	ModelAndView createOrSaveApplicationMaster(HttpServletRequest request) {
		Application_Master newEnvironmentMaster;
		if(request.getParameter("action").toString().equalsIgnoreCase("update")) {
			newEnvironmentMaster=applicationRepository.getOne(Integer.parseInt(request.getParameter("mId").toString()));
		}
		else {
			newEnvironmentMaster=new Application_Master();
		}	

		newEnvironmentMaster.setmName(request.getParameter("mName"));
		applicationRepository.save(newEnvironmentMaster);
    	return getAllApplicationMasters();
    }
	
	@GetMapping("/application/edit/{id}")
	ModelAndView getApplicationMasterById(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterItem", applicationRepository.findById(id).get());
		modelAndView.getModelMap().put("master", "application");
		modelAndView.getModelMap().put("master_action", "update");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView; }
 
	/*
	 * @PutMapping("/application/{id}") Application_Master
	 * updateApplicationMaster(@RequestBody Application_Master
	 * newApplicationMaster, @PathVariable Integer id) {
	 * 
	 * return applicationRepository.findById(id).map(application -> {
	 * application.setmName(newApplicationMaster.getmName()); return
	 * applicationRepository.save(application); }).orElseGet(() -> {
	 * newApplicationMaster.setmId(id); return
	 * applicationRepository.save(newApplicationMaster); }); }
	 */
 
    @PostMapping("/application/delete/{id}")
    ModelAndView deleteApplicationMaster(@PathVariable Integer id) {
        applicationRepository.deleteById(id);
        return new ModelAndView("redirect:http://localhost:8080/application-management/application"  );
    }
}
