package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserService {
    Page<User> getAllUsers(Pageable pageable);
    User getUserById(Long userId);
    User createUser(Long addressId, User userId);
    User updateUser(Long addressId, Long userId, User messageRequest);
    ResponseEntity<?> deleteUser(Long addressId, Long userId);
}
