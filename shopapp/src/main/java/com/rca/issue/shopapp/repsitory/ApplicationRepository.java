package com.rca.issue.shopapp.repsitory;

import com.rca.issue.shopapp.model.Application_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application_Master, Integer> {
}
