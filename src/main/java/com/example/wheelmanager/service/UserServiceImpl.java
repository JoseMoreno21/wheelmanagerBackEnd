package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.User;
import com.example.wheelmanager.domain.repository.AddressRepository;
import com.example.wheelmanager.domain.repository.UserRepository;
import com.example.wheelmanager.domain.service.UserService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable)
    {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));

    }

    @Override
    public User createUser(Long addressId, User user) {
        return addressRepository.findById(addressId).map(address -> {
            user.setAddress(address);
            return userRepository.save(user);
        }).orElseThrow(() -> new ResourceNotFoundException( "Address", "Id", addressId));
    }

    @Override
    public User updateUser(Long addressId, Long userId, User userRequest) {
        if(!addressRepository.existsById(addressId))
            throw new ResourceNotFoundException("Address" + "Id" + addressId);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "User", "Id", userId));
        return userRepository.save(
                user.setUserName(userRequest.getUserName())
                .setPassword(userRequest.getPassword())
                .setEmail(userRequest.getEmail())
                .setName(userRequest.getName())
                .setLastName(userRequest.getLastName())
                .setImageUrl(userRequest.getImageUrl())
                .setDni(userRequest.getDni())
                .setGender(userRequest.getGender()));
    }

    @Override
    public ResponseEntity<?> deleteUser(Long addressId, Long userId) {
        return userRepository.findByIdAndAddressId(userId, addressId).map(user -> {
            userRepository.delete(user);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Message not found with Id " + userId + " and AddressId " + addressId));
    }
}
