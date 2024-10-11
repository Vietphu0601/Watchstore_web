package com.webwatch.TimeHub.service;

import java.util.List;

import com.webwatch.TimeHub.domain.ProductImage;

public interface IProductImageService {
    public ProductImage save(ProductImage productImage);

    public List<ProductImage> findByProductId(Long id);

    public void deleteByProductId(Long id);
}
