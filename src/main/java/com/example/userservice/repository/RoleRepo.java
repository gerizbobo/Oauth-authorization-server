package com.example.userservice.repository;

import com.example.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role , Long> {
    Role findByName(String name);
}
