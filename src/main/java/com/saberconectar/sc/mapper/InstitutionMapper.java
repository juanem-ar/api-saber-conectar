package com.saberconectar.sc.mapper;

import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.dto.UserDTO;
import com.saberconectar.sc.entity.InstitutionEntity;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstitutionMapper {
    @Autowired
    private UserMapper userMapper;

    public InstitutionEntity institutionDTO2Entity(InstitutionDTO dto){
        InstitutionEntity entity = new InstitutionEntity();
        entity.setName(dto.getName());
        entity.setCuitNumber(dto.getCuitNumber());
        entity.setDeleted(dto.getDeleted());
        entity.setUserEntity(dto.getUserEntity());
        return entity;
    }
    public InstitutionDTO institutionEntity2DTO(InstitutionEntity entity){
        InstitutionDTO dto = new InstitutionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCuitNumber(entity.getCuitNumber());
        dto.setDeleted(entity.getDeleted());
        UserDTO userDTO = userMapper.userEntity2DTO(entity.getUserEntity(), false, false);
        UserEntity userEntity = userMapper.userDTO2Entity(userDTO);

        dto.setUserEntity(userEntity);


        return dto;
    }
    public InstitutionEntity update(InstitutionEntity entity, InstitutionDTO dto){
        entity.getId();
        entity.setName(dto.getName());
        entity.setCuitNumber(dto.getCuitNumber());
        entity.setDeleted(dto.getDeleted());

        UserDTO userDTO = userMapper.userEntity2DTO(dto.getUserEntity(), false, false);

        UserEntity userEntity = userMapper.update(entity.getUserEntity(), userDTO);
        entity.setUserEntity(userEntity);

        return entity;
    }
}
