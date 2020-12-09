package com.rca.issue.shopapp.model;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Issue_Master")
public class Issue_Master {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	private String title;
	
	private String description;
	
	private String issueAPI;
	
	private String jira_imId;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "reportedDate")
    private Date reportedDate;
	
	@Temporal(TemporalType.DATE)
    @Column(name = "resolvedDate")
    private Date resolvedDate;
	
	private String actionTaken;
	
	@OneToMany
	private List<Issue_Attachments> issueAttachement;
	
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "application_id", nullable = false)
	private Application_Master applicationMaster;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "environment_id", nullable = false)
	private Environment_Master environmentMaster;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "status_id", nullable = false)
	private Status_Master statusMaster;
	
	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Application_Master getApplicationMaster() {
		return applicationMaster;
	}

	public void setApplicationMaster(Application_Master applicationMaster) {
		this.applicationMaster = applicationMaster;
	}

	public Environment_Master getEnvironmentMaster() {
		return environmentMaster;
	}

	public void setEnvironmentMaster(Environment_Master environmentMaster) {
		this.environmentMaster = environmentMaster;
	}

	public Status_Master getStatusMaster() {
		return statusMaster;
	}

	public void setStatusMaster(Status_Master statusMaster) {
		this.statusMaster = statusMaster;
	}
}
