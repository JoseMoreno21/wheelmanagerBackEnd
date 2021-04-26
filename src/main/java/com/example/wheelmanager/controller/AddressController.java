package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Address;
import com.example.wheelmanager.domain.service.AddressService;
import com.example.wheelmanager.resource.AddressResource;
import com.example.wheelmanager.resource.SaveAddressResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
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

//@Tag(name = "Address", description = "Address API")
@RestController
@CrossOrigin
@RequestMapping("/api")

public class AddressController {
    @Autowired
    AddressService addressService;
    @Autowired
    private ModelMapper mapper;

    @Operation(summary = "Get Addresses", description = "Get all addresses by pages", tags={"Addresses"})
    @ApiResponse(responseCode = "200", description = "All addresses returned correctly", content = @Content(mediaType = "application/json"))
    @GetMapping("/addresses")
    public Page<AddressResource> getAllAddresses(Pageable pageable) {

        Page<Address> addressPage = addressService.getAllAddresses(pageable);
        List<AddressResource> resources = addressPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @Operation(summary = "Get Addresses by Id", description = "Get address by Id", tags={"Addresses"})
    @ApiResponse(responseCode = "200", description = "Address returned correctly", content = @Content(mediaType = "application/json"))
    @GetMapping("/addresses/{addressId}")
    public AddressResource getAddressById(@PathVariable(value = "addressId") Long addressId) {
        return convertToResource(addressService.getAddressById(addressId));
    }

    @Operation(summary = "Create Addresses", description = "Create address", tags={"Addresses"})
    @ApiResponse(responseCode = "200", description = "Create address correctly", content = @Content(mediaType = "application/json"))
    @PostMapping("/addresses")
    public AddressResource createAddress(
            @Valid @RequestBody SaveAddressResource resource) {
        Address address = convertToEntity(resource);
        return convertToResource(addressService.createAddress(address));

    }

    @Operation(summary = "Update Addresses", description = "Update address for given Id", tags={"Addresses"})
    @ApiResponse(responseCode = "200", description = "Address updates correctly", content = @Content(mediaType = "application/json"))
    @PutMapping("/addresses/{addressId}")
    public AddressResource updateAddress(@PathVariable Long addressId,
                                         @Valid @RequestBody SaveAddressResource resource) {
        Address address = convertToEntity(resource);
        return convertToResource(
                addressService.updateAddress(addressId, address));
    }

    @Operation(summary = "Get Addresses", description = "Delete address for given id", tags={"Addresses"})
    @ApiResponse(responseCode = "200", description = "Address deleted correctly", content = @Content(mediaType = "application/json"))
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
