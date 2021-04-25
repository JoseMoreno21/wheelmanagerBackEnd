package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
