package com.example.wheelmanager.controller;

import com.example.wheelmanager.domain.model.Brand;
import com.example.wheelmanager.domain.service.BrandService;
import com.example.wheelmanager.resource.BrandResource;
import com.example.wheelmanager.resource.SaveBrandResource;
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

@Tag(name ="Brand",description = "Brand API")
@RestController
@CrossOrigin
@RequestMapping("/api")
public class BrandController {
    @Autowired
    BrandService brandService;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/brands")
    public Page<BrandResource> getAllBrands(Pageable pageable){
        Page<Brand> brandsPage = brandService.getAllBrands(pageable);
        List<BrandResource> resources = brandsPage.getContent()
                .stream().map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(resources,pageable,resources.size());
    }

    @GetMapping("/brands/{brandId}")
    public BrandResource getBrandById(@PathVariable(value = "brandId")Long brandId){
        return convertToResource(brandService.getBrandById(brandId));
    }

    @PostMapping("/brands")
    public BrandResource createBrand(@Valid @RequestBody SaveBrandResource resource) {
        Brand brand = convertToEntity(resource);
        return convertToResource(brandService.createBrand(brand));
    }

    @PutMapping("/brands/{brandId}")
    public BrandResource updateBrand(@PathVariable Long brandId,
                                     @Valid @RequestBody SaveBrandResource resource){
        Brand brand=convertToEntity(resource);
        return convertToResource(brandService.updateBrand(brandId,brand));
    }

    @DeleteMapping("/brands/{brandId}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long brandId){
        return brandService.deleteBrand(brandId);
    }

    private Brand convertToEntity(SaveBrandResource resource) {
        return mapper.map(resource,Brand.class);
    }

    private BrandResource convertToResource(Brand entity) {
        return mapper.map(entity, BrandResource.class);
    }

}
