package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndAddressId(Long id, Long addressId);
}
