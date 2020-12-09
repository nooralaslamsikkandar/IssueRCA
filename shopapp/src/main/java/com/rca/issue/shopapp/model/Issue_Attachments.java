package com.rca.issue.shopapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Issue_Attachments")
public class Issue_Attachments {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer mId;
	
	/*
	 * @OneToMany(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "issueID", nullable = false)
	 */
	private Integer issueID;
	
	@Lob
	private byte[] attachement;

	public Integer getmId() {
		return mId;
	}

	public void setmId(Integer mId) {
		this.mId = mId;
	}

	public Integer getIssueID() {
		return issueID;
	}

	public void setIssueID(Integer issueID) {
		this.issueID = issueID;
	}

	public byte[] getAttachement() {
		return attachement;
	}

	public void setAttachement(byte[] attachement) {
		this.attachement = attachement;
	}

}
