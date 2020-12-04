package com.rca.issue.shopapp.repsitory;

import com.rca.issue.shopapp.model.Environment_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvironmentRepository extends JpaRepository<Environment_Master, Integer> {
}
   