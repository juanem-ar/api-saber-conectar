package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.ProductDTO;
import com.saberconectar.sc.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public List<ProductDTO> getAllProducts() {
        return null;
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        return null;
    }

    @Override
    public ProductDTO update(Long id, ProductDTO product) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void isCorrect(Long id) {

    }
}
