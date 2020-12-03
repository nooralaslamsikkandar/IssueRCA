package com.rca.issue.shopapp.controller;

import java.util.List;

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

import com.rca.issue.shopapp.model.Application_Master;
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
	public List<Application_Master> getAllApplicationMasters() {
        return applicationRepository.findAll();
    }
	
	@PostMapping("/application")
	Application_Master createOrSaveApplicationMaster(@RequestBody Application_Master newApplicationMaster) {
    	return applicationRepository.save(newApplicationMaster);
    }
	
	@GetMapping("/application/{id}")
	Application_Master getApplicationMasterById(@PathVariable Integer id) {
        return applicationRepository.findById(id).get();
    }
 
    @PutMapping("/application/{id}")
    Application_Master updateApplicationMaster(@RequestBody Application_Master newApplicationMaster, @PathVariable Integer id) {
 
    	return applicationRepository.findById(id).map(application -> {
    		application.setApplicationName(newApplicationMaster.getApplicationName());
            return applicationRepository.save(application);
        }).orElseGet(() -> {
            newApplicationMaster.setApplicationID(id);
            return applicationRepository.save(newApplicationMaster);
        });
    }
 
    @DeleteMapping("/application/{id}")
    void deleteApplicationMaster(@PathVariable Integer id) {
        applicationRepository.deleteById(id);
    }
}
