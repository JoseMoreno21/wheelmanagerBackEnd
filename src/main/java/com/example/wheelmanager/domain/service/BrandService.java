package com.example.wheelmanager.domain.service;

import com.example.wheelmanager.domain.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface BrandService {
    Page<Brand> getAllBrands(Pageable pageable);
    Brand getBrandById(Long brandId);
    Brand createBrand(Brand brand);
    Brand updateBrand(Long brandId, Brand messageRequest);
    ResponseEntity<?> deleteBrand(Long brandId);
}
