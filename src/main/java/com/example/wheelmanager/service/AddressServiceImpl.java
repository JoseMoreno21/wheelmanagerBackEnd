package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Address;
import com.example.wheelmanager.domain.repository.AddressRepository;
import com.example.wheelmanager.domain.service.AddressService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Page<Address> getAllAddresses(Pageable pageable)
    {
        return addressRepository.findAll(pageable);
    }

    @Override
    public Address getAddressById(Long addressId){
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Address", "Id", addressId));

    }

    @Override
    public Address createAddress(Address address) { return addressRepository.save(address); }

    @Override
    public Address updateAddress(Long addressId, Address addressRequest) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Address", "Id", addressId));
        return addressRepository.save(
                address.setLatitude(addressRequest.getLatitude())
                        .setLongitude(addressRequest.getLongitude())
                        .setDescription(addressRequest.getDescription()));
    }

    @Override
    public ResponseEntity<?> deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Address", "Id", addressId));
        addressRepository.delete(address);
        return ResponseEntity.ok().build();
    }
}
