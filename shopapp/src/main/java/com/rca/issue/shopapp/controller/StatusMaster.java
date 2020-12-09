package com.rca.issue.shopapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rca.issue.shopapp.model.Status_Master;
import com.rca.issue.shopapp.repsitory.StatusRepository;

@RestController
@RequestMapping(value = "/application-management", produces = { MediaType.APPLICATION_JSON_VALUE })
public class StatusMaster {
	
	@Autowired
	private StatusRepository statusRepository; 
 
	public StatusRepository getApplicationRepository() {
		return statusRepository;
	}

	public void setApplicationRepository(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}
	
	@GetMapping(value = "/status")
	public ModelAndView getAllApplicationMasters() {
		if(statusRepository.findAll().size()>0) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterList", statusRepository.findAll());
		modelAndView.getModelMap().put("master", "status");
		modelAndView.setViewName("master");
		 return modelAndView;
		}else
		{
			return addApplicationMasters();
		}}
	@GetMapping(value = "/status/add")
	public ModelAndView addApplicationMasters() {
        //return statusRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterList", "add");
		modelAndView.getModelMap().put("master", "status");
		modelAndView.getModelMap().put("master_action", "new");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
	
	@PostMapping("/status")
	ModelAndView createOrSaveApplicationMaster(	HttpServletRequest request) {
		Status_Master newStatusMaster;
	if(request.getParameter("action").toString().equalsIgnoreCase("Make Update")) {
		newStatusMaster=statusRepository.getOne(Integer.parseInt(request.getParameter("mId").toString()));
	}
	else {
		newStatusMaster=new Status_Master();
	}	

	newStatusMaster.setmName(request.getParameter("mName"));
	statusRepository.save(newStatusMaster);
	return getAllApplicationMasters();}
	
	@GetMapping("/status/edit/{id}")
	ModelAndView getApplicationMasterById(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterItem", statusRepository.findById(id).get());
		modelAndView.getModelMap().put("master", "status");
		modelAndView.getModelMap().put("master_action", "Make Update");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
 
//    @PutMapping("/status/edit/{id}")
//    ModelAndView updateApplicationMaster(@RequestBody Status_Master newStatusMaster, @PathVariable Integer id) {
//    		ModelAndView modelAndView = new ModelAndView();
//    		modelAndView.getModelMap().put("masterItem", statusRepository.findById(id).get());
//    		modelAndView.getModelMap().put("master", "status");
//    		modelAndView.setViewName("masterViewAndEdit");
//            return modelAndView;
//    }
 
    @PostMapping("/status/delete/{id}")
    ModelAndView deleteApplicationMaster(@PathVariable Integer id) {
        statusRepository.deleteById(id);
        return new ModelAndView("redirect:http://localhost:8080/application-management/status"  );
    }
}
