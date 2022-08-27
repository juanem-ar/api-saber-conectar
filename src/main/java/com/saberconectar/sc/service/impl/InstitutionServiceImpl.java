package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.InstitutionMapper;
import com.saberconectar.sc.repository.InstitutionRepository;
import com.saberconectar.sc.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionServiceImpl implements InstitutionService {
    @Autowired
    private InstitutionRepository institutionRepository;
    @Autowired
    private InstitutionMapper institutionMapper;

    public InstitutionDTO institutionRegister(InstitutionDTO dto) {
        InstitutionEntity entity = institutionMapper.institutionDTO2Entity(dto);
        InstitutionEntity entitySaved = institutionRepository.save(entity);
        InstitutionDTO result = institutionMapper.institutionEntity2DTO(entitySaved);
        return result;
    }
    public void delete(Long id) {
        isCorrect(id);
        this.institutionRepository.deleteById(id);
    }

    public InstitutionDTO getInstitutionById(Long id) {
        isCorrect(id);
        InstitutionEntity entity = institutionRepository.getReferenceById(id);
        InstitutionDTO dto = institutionMapper.institutionEntity2DTO(entity);
        return dto;
    }
    public InstitutionDTO update(Long id, InstitutionDTO institution) {
        isCorrect(id);
        InstitutionEntity entityId = institutionRepository.getReferenceById(id);
        InstitutionEntity entity = institutionMapper.update(entityId, institution);
        InstitutionEntity entityUpdated = institutionRepository.save(entity);
        InstitutionDTO dto = institutionMapper.institutionEntity2DTO(entityUpdated);
        return dto;
    }
    public void isCorrect(Long id){
        if(!institutionRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
