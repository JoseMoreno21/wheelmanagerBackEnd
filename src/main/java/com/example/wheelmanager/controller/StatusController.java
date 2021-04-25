package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Status;
import com.example.wheelmanager.domain.service.StatusService;
import com.example.wheelmanager.resource.SaveStatusResource;
import com.example.wheelmanager.resource.StatusResource;
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

@Tag(name = "Status", description = "Status API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class StatusController {
    @Autowired
    StatusService statusService;
    @Autowired
    private ModelMapper mapper;

    @GetMapping("/statuses")
    public Page<StatusResource> getAllStatuses(Pageable pageable) {

        Page<Status> statusPage = statusService.getAllStatuses(pageable);
        List<StatusResource> resources = statusPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/statuses/{statusId}")
    public StatusResource getStatusById(@PathVariable(value = "statusId") Long statusId) {
        return convertToResource(statusService.getStatusById(statusId));
    }

    @PostMapping("/statuses")
    public StatusResource createStatus(
            @Valid @RequestBody SaveStatusResource resource) {
        Status status = convertToEntity(resource);
        return convertToResource(statusService.createStatus(status));

    }

    @PutMapping("/statuses/{statusId}")
    public StatusResource updateStatus(@PathVariable Long statusId,
                                               @Valid @RequestBody SaveStatusResource resource) {
        Status status = convertToEntity(resource);
        return convertToResource(
                statusService.updateStatus(statusId, status));
    }

    @DeleteMapping("/statuses/{statusId}")
    public ResponseEntity<?> deleteStatus(@PathVariable Long statusId) {
        return statusService.deleteStatus(statusId);
    }

    private Status convertToEntity(SaveStatusResource resource) {

        return mapper.map(resource, Status.class);
    }

    private StatusResource convertToResource(Status entity) {
        return mapper.map(entity, StatusResource.class);
    }

}
