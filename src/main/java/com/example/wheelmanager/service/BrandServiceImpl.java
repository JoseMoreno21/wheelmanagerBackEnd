package com.example.wheelmanager.service;

import com.example.wheelmanager.domain.model.Brand;
import com.example.wheelmanager.domain.repository.BrandRepository;
import com.example.wheelmanager.domain.service.BrandService;
import com.example.wheelmanager.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Page<Brand> getAllBrands(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    @Override
    public Brand getBrandById(Long brandId) {
        return brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException(
                "Brand","Id", brandId));
    }

    @Override
    public Brand createBrand(Brand brand) {
        return brandRepository.save(brand);
    }

    @Override
    public Brand updateBrand(Long brandId, Brand brandRequest) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Brand", "Id", brandId));
        return brandRepository.save(
                brand.setBrandName(brandRequest.getBrandName()));
    }

    @Override
    public ResponseEntity<?> deleteBrand(Long brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Brand", "Id", brandId));
        brandRepository.delete(brand);
        return ResponseEntity.ok().build();
    }

}
