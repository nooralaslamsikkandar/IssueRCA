package com.rca.issue.shopapp.repsitory;

import com.rca.issue.shopapp.model.Application_Master;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application_Master, Integer> {

	/*
	 * public default Optional<Application_Master> findById(Integer id) {
	 * Optional<Application_Master> application = findById(id); return application
	 * != null ? application : Optional.empty(); }
	 */
	
	Application_Master findBymId(Integer id);
	 
}
