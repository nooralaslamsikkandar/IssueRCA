package com.rca.issue.shopapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Application_Master")
public class Application_Master {
	
	public Application_Master()
	{
		
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	private String mName;
	
	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}
}
