package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Vehicle;
import com.example.wheelmanager.domain.service.VehicleService;
import com.example.wheelmanager.resource.SaveVehicleResource;
import com.example.wheelmanager.resource.VehicleResource;
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

@Tag(name = "Vehicle",description = "Vehicle API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/vehicles")
    public Page<VehicleResource> getAllVehicles(Pageable pageable){
        Page<Vehicle>  vehiclePage = vehicleService.getAllVehicles(pageable);
        List<VehicleResource> resources = vehiclePage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/vehicles/{vehicleId}")
    public VehicleResource getVehicleById(@PathVariable(value = "vehicleId")Long vehicleId){
        return convertToResource(vehicleService.getVehicleById(vehicleId));
    }

    @PostMapping("/vehicles")
    public VehicleResource createVehicle(@Valid @RequestBody SaveVehicleResource resource){
        Vehicle vehicle = convertToEntity(resource);
        return convertToResource(vehicleService.createVehicle(vehicle));
    }

    @PutMapping("/vehicles/{vehicleId}")
    public VehicleResource updateVehicle(@PathVariable Long vehicleId, @Valid @RequestBody SaveVehicleResource resource){
        Vehicle vehicle = convertToEntity(resource);
        return convertToResource(vehicleService.updateVehicle(vehicleId,vehicle));
    }

    @DeleteMapping("/vehicles/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long vehicleId){
        return vehicleService.deleteVehicle(vehicleId);
    }

    private Vehicle convertToEntity(SaveVehicleResource resource) {
        return mapper.map(resource,Vehicle.class);
    }

    private VehicleResource convertToResource(Vehicle entity) {
        return mapper.map(entity,VehicleResource.class);
    }
}
