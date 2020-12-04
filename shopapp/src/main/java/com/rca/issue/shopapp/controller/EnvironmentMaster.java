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

import com.rca.issue.shopapp.model.Environment_Master;
import com.rca.issue.shopapp.repsitory.EnvironmentRepository;

@RestController
@RequestMapping(value = "/application-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class EnvironmentMaster {
	
	@Autowired
	private EnvironmentRepository environmentRepository;

	public EnvironmentRepository getApplicationRepository() {
		return environmentRepository;
	}

	public void setEnvironmentRepository(EnvironmentRepository environmentRepository) {
		this.environmentRepository = environmentRepository;
	}
	
	@GetMapping(value = "/environment")
	public List<Environment_Master> getAllApplicationMasters() {
        return environmentRepository.findAll();
    }
	
	@PostMapping("/environment")
	Environment_Master createOrSaveApplicationMaster(@RequestBody Environment_Master newEnvironmentMaster) {
    	return environmentRepository.save(newEnvironmentMaster);
    }
	
	@GetMapping("/environment/{id}")
	Environment_Master getApplicationMasterById(@PathVariable Integer id) {
        return environmentRepository.findById(id).get();
    }
 
    @PutMapping("/environment/{id}")
    Environment_Master updateApplicationMaster(@RequestBody Environment_Master newEnvironmentMaster, @PathVariable Integer id) {
 
    	return environmentRepository.findById(id).map(environment -> {
    		environment.setEnvironmentName(newEnvironmentMaster.getEnvironmentName());
            return environmentRepository.save(environment);
        }).orElseGet(() -> {
            newEnvironmentMaster.setEnvironmentID(id);
            return environmentRepository.save(newEnvironmentMaster);
        });
    }
 
    @DeleteMapping("/environment/{id}")
    void deleteApplicationMaster(@PathVariable Integer id) {
        environmentRepository.deleteById(id);
    }
}
