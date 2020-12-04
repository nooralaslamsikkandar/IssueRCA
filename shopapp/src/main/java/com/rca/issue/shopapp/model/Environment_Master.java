package com.rca.issue.shopapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Environment_Master")
public class Environment_Master {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int EnvironmentID;
	
	private String EnvironmentName;
 
	public int getEnvironmentID() {
		return EnvironmentID;
	}

	public void setEnvironmentID(int applicationID) {
		EnvironmentID = applicationID;
	}

	public String getEnvironmentName() {
		return EnvironmentName;
	}

	public void setEnvironmentName(String applicationName) {
		EnvironmentName = applicationName;
	}
	
	
}
