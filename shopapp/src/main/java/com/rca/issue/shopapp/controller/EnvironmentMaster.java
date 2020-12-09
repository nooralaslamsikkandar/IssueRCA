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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rca.issue.shopapp.model.Environment_Master;
import com.rca.issue.shopapp.model.Issue_Master;
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
		if(environmentRepository.findAll().size()>0) {
		ModelAndView modelAndView = new ModelAndView("master", "command",null);
		modelAndView.getModelMap().put("masterList", environmentRepository.findAll());
		modelAndView.getModelMap().put("master", "environment");
		//modelAndView.setViewName("master");
        return modelAndView;
		}else
		{
			return addApplicationMasters();
		}
    }
	
	@GetMapping(value = "/environment/add")
	public ModelAndView addApplicationMasters() {
        //return environmentRepository.findAll();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterList", "add");
		modelAndView.getModelMap().put("master", "environment");
		modelAndView.getModelMap().put("master_action", "new");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
	@PostMapping("/environment")
	ModelAndView createOrSaveApplicationMaster(HttpServletRequest request) {
		Environment_Master newEnvironmentMaster;
		if(request.getParameter("action").toString().equalsIgnoreCase("Make Update")) {
			newEnvironmentMaster=environmentRepository.getOne(Integer.parseInt(request.getParameter("mId").toString()));
		}
		else {
			newEnvironmentMaster=new Environment_Master();
		}	

		newEnvironmentMaster.setmName(request.getParameter("mName"));
        environmentRepository.save(newEnvironmentMaster);
    	return getAllApplicationMasters();
    }
	
	@GetMapping("/environment/edit/{id}")
	ModelAndView getApplicationMasterById(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.getModelMap().put("masterItem", environmentRepository.findById(id).get());
		modelAndView.getModelMap().put("master", "environment");
		modelAndView.getModelMap().put("master_action", "Make Update");
		modelAndView.setViewName("masterViewAndEdit");
        return modelAndView;
    }
 
	/*
	 * @PostMapping("/environment/{id}") ModelAndView
	 * updateApplicationMaster(HttpServletRequest request) { Environment_Master
	 * newEnvironmentMaster=new Environment_Master();
	 * if(request.getParameter("mId").toString() != null){
	 * newEnvironmentMaster=environmentRepository.findBymId(Integer.parseInt(request
	 * .getParameter( "mId").toString()));
	 * if(newEnvironmentMaster!=null&&Integer.parseInt(request.getParameter("mId"))=
	 * =newEnvironmentMaster.getmId()) {
	 * newEnvironmentMaster.setmName(request.getParameter("mName"));
	 * environmentRepository.save(newEnvironmentMaster); } } return
	 * getAllApplicationMasters(); }
	 */
    @PostMapping("/environment/delete/{id}")
    ModelAndView deleteApplicationMaster(@PathVariable Integer id) {
        environmentRepository.deleteById(id);
        return new ModelAndView("redirect:http://localhost:8080/application-management/environment"  );
    }
}
