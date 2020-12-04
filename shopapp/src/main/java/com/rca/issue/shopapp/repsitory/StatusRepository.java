package com.rca.issue.shopapp.repsitory;

import com.rca.issue.shopapp.model.Status_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status_Master, Integer> {
}
 