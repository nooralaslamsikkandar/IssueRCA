package com.rca.issue.shopapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Status_Master")
public class Status_Master {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int StatusID;
	
	private String StatusName;

	public int getStatusID() {
		return StatusID;
	}

	public void setStatusID(int applicationID) {
		StatusID = applicationID;
	}

	public String getStatusName() {
		return StatusName;
	}

	public void setStatusName(String applicationName) {
		StatusName = applicationName;
	}
	
	
}

