package com.saberconectar.sc.dto;

import com.saberconectar.sc.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class StudentDTO {
    private Long id;
    private String name;
    private String surname;
    private String documentNumber;
    private LocalDate date;
    private Boolean deleted;
    private UserEntity userEntity;
}
