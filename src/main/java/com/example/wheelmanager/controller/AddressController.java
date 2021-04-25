package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Address;
import com.example.wheelmanager.domain.service.AddressService;
import com.example.wheelmanager.resource.AddressResource;
import com.example.wheelmanager.resource.SaveAddressResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Address", description = "Address API")
@RestController
@CrossOrigin
@RequestMapping("/api")

public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/addresses")
    public Page<AddressResource> getAllCards(Pageable pageable) {

        Page<Address> addressPage = addressService.getAllAddresses(pageable);
        List<AddressResource> resources = addressPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/addresses/{addressId}")
    public AddressResource getAddressById(@PathVariable(value = "addressId") Long addressId) {
        return convertToResource(addressService.getAddressById(addressId));
    }

    @PostMapping("/addresses")
    public AddressResource createAddress(
            @Valid @RequestBody SaveAddressResource resource) {
        Address address = convertToEntity(resource);
        return convertToResource(addressService.createAddress(address));

    }

    @PutMapping("/addresses/{addressId}")
    public AddressResource updateAddress(@PathVariable Long addressId,
                                         @Valid @RequestBody SaveAddressResource resource) {
        Address address = convertToEntity(resource);
        return convertToResource(
                addressService.updateAddress(addressId, address));
    }

    @DeleteMapping("/addresses/{addressId}")
    public ResponseEntity<?> deleteAddress(@PathVariable Long addressId) {
        return addressService.deleteAddress(addressId);
    }

    private Address convertToEntity(SaveAddressResource resource) {

        return mapper.map(resource, Address.class);
    }

    private AddressResource convertToResource(Address entity) {
        return mapper.map(entity, AddressResource.class);
    }
}
