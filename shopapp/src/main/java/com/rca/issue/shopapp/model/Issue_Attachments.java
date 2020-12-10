package com.rca.issue.shopapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Issue_Attachments")
public class Issue_Attachments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "isssue_ID", nullable = false)
	private Issue_Master issueMaster;
	
	@Lob
	private byte[] attachement;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	private String fileName;
	private String fileType;
	
	public Integer getmId() {
		return mId;
	}

	public Issue_Master getIssueMaster() {
		return issueMaster;
	}

	public void setIssueMaster(Issue_Master issueMaster) {
		this.issueMaster = issueMaster;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	

	public byte[] getAttachement() {
		return attachement;
	}

	public void setAttachement(byte[] attachement) {
		this.attachement = attachement;
	}

}
