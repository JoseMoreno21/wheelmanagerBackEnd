package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
