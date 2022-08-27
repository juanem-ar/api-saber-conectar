package com.saberconectar.sc.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "student")
@Getter
@Setter
@SQLDelete(sql = "UPDATE student SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    @Column(name = "document_number")
    private String documentNumber;
    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    //soft-delete
    private Boolean deleted = Boolean.FALSE;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}
