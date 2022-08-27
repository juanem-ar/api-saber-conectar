package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InstitutionDTO {
    private Long id;
    private String name;
    private String cuitNumber;
    private Boolean deleted;
    private UserEntity userEntity;
}
