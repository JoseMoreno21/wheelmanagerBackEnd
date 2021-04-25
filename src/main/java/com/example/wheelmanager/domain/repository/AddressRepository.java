package com.example.wheelmanager.domain.repository;

import com.example.wheelmanager.domain.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
