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

import com.rca.issue.shopapp.model.Status_Master;
import com.rca.issue.shopapp.repsitory.StatusRepository;

@RestController
@RequestMapping(value = "/application-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class ApplicationMaster {
	
	@Autowired
	private StatusRepository statusRepository; 

	public StatusRepository getApplicationRepository() {
		return statusRepository;
	}

	public void setApplicationRepository(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}
	
	@GetMapping(value = "/status")
	public List<Status_Master> getAllApplicationMasters() {
        return statusRepository.findAll();
    }
	
	@PostMapping("/status")
	Status_Master createOrSaveApplicationMaster(@RequestBody Status_Master newStatusMaster) {
    	return statusRepository.save(newStatusMaster);
    }
	
	@GetMapping("/status/{id}")
	Status_Master getApplicationMasterById(@PathVariable Integer id) {
        return statusRepository.findById(id).get();
    }
 
    @PutMapping("/status/{id}")
    Status_Master updateApplicationMaster(@RequestBody Status_Master newStatusMaster, @PathVariable Integer id) {
 
    	return statusRepository.findById(id).map(status -> {
    		status.setStatus(newStatusMaster.getStatus());
            return statusRepository.save(status);
        }).orElseGet(() -> {
            newStatusMaster.setStatusID(id);
            return statusRepository.save(newStatusMaster);
        });
    }
 
    @DeleteMapping("/status/{id}")
    void deleteApplicationMaster(@PathVariable Integer id) {
        statusRepository.deleteById(id);
    }
}
