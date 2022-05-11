package com.example.userservice.repository;

import com.example.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User , Long> {
    User findUserByUsername(String username);
}
