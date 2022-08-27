package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.InstitutionDTO;

public interface InstitutionService {
    InstitutionDTO getInstitutionById(Long id);
    InstitutionDTO institutionRegister(InstitutionDTO dto);
    InstitutionDTO update(Long id, InstitutionDTO dto);
    void delete(Long id);
    void isCorrect(Long id);
}
