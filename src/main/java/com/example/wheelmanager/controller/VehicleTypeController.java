package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.VehicleType;
import com.example.wheelmanager.domain.service.VehicleTypeService;
import com.example.wheelmanager.resource.SaveVehicleTypeResource;
import com.example.wheelmanager.resource.VehicleTypeResource;
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

@Tag(name = "VehicleType",description = "VehicleType API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class VehicleTypeController {
    @Autowired
    VehicleTypeService vehicleTypeService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/vehicletypes")
    public Page<VehicleTypeResource> getAllVehicleTypes(Pageable pageable){
        Page<VehicleType>  vehicleTypesPage = vehicleTypeService.getAllVehicleTypes(pageable);
        List<VehicleTypeResource> resources = vehicleTypesPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/vehicletypes/{vehicleTypeId}")
    public VehicleTypeResource getVehicleTypeById(@PathVariable(value = "vehicletypeId")Long vehicleTypeId){
        return convertToResource(vehicleTypeService.getVehicleTypeById(vehicleTypeId));
    }

    @PostMapping("/vehicletypes")
    public VehicleTypeResource createVehicleType(@Valid @RequestBody SaveVehicleTypeResource resource){
        VehicleType vehicleType=convertToEntity(resource);
        return convertToResource(vehicleTypeService.createVehicleType(vehicleType));
    }

    @PutMapping("/vehicletypes/{vehicleTypeId}")
    public VehicleTypeResource updateVehicleType(@PathVariable Long vehicleTypeId, @Valid @RequestBody SaveVehicleTypeResource resource){
        VehicleType vehicleType=convertToEntity(resource);
        return convertToResource(vehicleTypeService.updateVehicleType(vehicleTypeId,vehicleType));
    }

    @DeleteMapping("/vehicletypes/{vehicleTypeId}")
    public ResponseEntity<?> deleteVehicleType(@PathVariable Long vehicleTypeId){
        return vehicleTypeService.deleteVehicleType(vehicleTypeId);
    }

    private VehicleType convertToEntity(SaveVehicleTypeResource resource) {
        return mapper.map(resource,VehicleType.class);
    }

    private VehicleTypeResource convertToResource(VehicleType entity) {
        return mapper.map(entity,VehicleTypeResource.class);
    }
}