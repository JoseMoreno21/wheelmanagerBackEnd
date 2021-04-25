package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Status;
import com.example.wheelmanager.domain.repository.StatusRepository;
import com.example.wheelmanager.domain.service.StatusService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    private StatusRepository statusRepository;

    @Override
    public Page<Status> getAllStatuses(Pageable pageable)
    {
        return statusRepository.findAll(pageable);
    }

    @Override
    public Status getStatusById(Long statusId){
        return statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Status", "Id", statusId));

    }

    @Override
    public Status createStatus(Status status) { return statusRepository.save(status); }

    @Override
    public Status updateStatus(Long statusId, Status statusRequest) {
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Status", "Id", statusId));
        return statusRepository.save(
                status.setName(statusRequest.getName()));
    }

    @Override
    public ResponseEntity<?> deleteStatus(Long statusId) {
        Status status = statusRepository.findById(statusId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Status", "Id", statusId));
        statusRepository.delete(status);
        return ResponseEntity.ok().build();
    }
}
