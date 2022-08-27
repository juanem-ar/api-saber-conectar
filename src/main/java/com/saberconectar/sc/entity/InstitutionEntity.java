package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "institution")
@Getter
@Setter
@SQLDelete(sql = "UPDATE institution SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class InstitutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String cuitNumber;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;
    //User relationship
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
