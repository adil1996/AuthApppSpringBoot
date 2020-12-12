package com.forskills.authentication.repo;

import com.forskills.authentication.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Integer> {
    UserDetails findByEmail(String email);
}
