package com.webwatch.TimeHub.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.webwatch.TimeHub.domain.ProductImage;
import com.webwatch.TimeHub.repository.ProductImageRepository;
import com.webwatch.TimeHub.service.IProductImageService;

@Service
public class ProductImageService implements IProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageService(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage save(ProductImage productImage) {
        return this.productImageRepository.save(productImage);
    }

    @Override
    public List<ProductImage> findByProductId(Long id) {
        return this.productImageRepository.findByProductId(id);
    }

    @Override
    public void deleteByProductId(Long id) {
        this.productImageRepository.deleteByProductId(id);
    }

}
