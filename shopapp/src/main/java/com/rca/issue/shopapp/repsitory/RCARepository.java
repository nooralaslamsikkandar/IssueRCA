package com.rca.issue.shopapp.repsitory;

import com.rca.issue.shopapp.model.Issue_Master;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RCARepository extends JpaRepository<Issue_Master, Integer> {
}
 