package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long> {
}
