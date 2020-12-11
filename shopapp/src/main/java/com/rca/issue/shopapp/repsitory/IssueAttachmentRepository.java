package com.rca.issue.shopapp.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;


import com.rca.issue.shopapp.model.Issue_Attachments;


public interface IssueAttachmentRepository extends JpaRepository<Issue_Attachments, Integer> {
	Issue_Attachments deleteByissueMaster(Integer id);
	
}