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
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getAllApplicationMasters() {
        //return environmentRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("master", "command",null);
		modelAndView.getModelMap().put("masterList", environmentRepository.findAll());
		modelAndView.getModelMap().put("master", "environment");
		//modelAndView.setViewName("master");
        return modelAndView;
    }
	
	@PostMapping("/environment")
	Environment_Master createOrSaveApplicationMaster(@RequestBody Environment_Master newEnvironmentMaster) {
    	return environmentRepository.save(newEnvironmentMaster);
    }
	
	@GetMapping("/environment/edit/{id}")
	ModelAndView getApplicationMasterById(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterItem", environmentRepository.findById(id).get());
		modelAndView.getModelMap().put("master", "environment");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
 
    @PostMapping("/environment/{id}")
    ModelAndView updateApplicationMaster(@PathVariable Integer id) {
    	
    	Environment_Master newEnvironmentMaster=new Environment_Master();
    	newEnvironmentMaster.setmId(id);
    	newEnvironmentMaster.setmName("TEST");
    	return environmentRepository.findById(id).map(environment -> {
    		environment.setmName(newEnvironmentMaster.getmName());
            environmentRepository.save(environment);
            return getAllApplicationMasters();
        }).orElseGet(() -> {
            newEnvironmentMaster.setmId(id);
            environmentRepository.save(newEnvironmentMaster);
            return getAllApplicationMasters();
        });
    }
 
    @PostMapping("/environment/delete/{id}")
    ModelAndView deleteApplicationMaster(@PathVariable Integer id) {
        environmentRepository.deleteById(id);
        return getAllApplicationMasters();
    }
}
