package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.CityDTO;

import java.util.List;

public interface InvoiceTypeService {
    List<InvoiceTypeDTO> getAll();
    InvoiceTypeDTO save(InvoiceTypeDTO type);
    InvoiceTypeDTO update(Long id, InvoiceTypeDTO type);
    void delete (Long id);
    void isCorrect(Long id);
}
