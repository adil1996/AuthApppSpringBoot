package com.forskills.authentication.repo;

import com.forskills.authentication.model.TestDetails;
import com.forskills.authentication.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDetailsRepo extends JpaRepository<TestDetails, Integer> {
}
