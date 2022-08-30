package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CityDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();
    ProductDTO save(ProductDTO product);
    ProductDTO update(Long id, ProductDTO product);
    void delete (Long id);
    void isCorrect(Long id);
}
