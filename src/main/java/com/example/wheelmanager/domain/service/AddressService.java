package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    Page<Address> getAllAddresses(Pageable pageable);
    Address getAddressById(Long addressId);
    Address createAddress(Address address);
    Address updateAddress(Long addressId, Address messageRequest);
    ResponseEntity<?> deleteAddress(Long addressId);
}
