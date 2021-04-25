package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface StatusService {
    Page<Status> getAllStatuses(Pageable pageable);
    Status getStatusById(Long statusId);
    Status createStatus(Status statusId);
    Status updateStatus(Long statusId, Status messageRequest);
    ResponseEntity<?> deleteStatus(Long statusId);
}
