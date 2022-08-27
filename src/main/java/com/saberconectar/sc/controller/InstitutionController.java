package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.InstitutionDTO;
import com.saberconectar.sc.service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("institutions")
public class InstitutionController {

    @Autowired
    private InstitutionService institutionService;

    @GetMapping("/{id}")
    public ResponseEntity<InstitutionDTO> getInstitutionById(@PathVariable Long id){
        InstitutionDTO institution = institutionService.getInstitutionById(id);
        return ResponseEntity.ok().body(institution);
    }
    @PostMapping
    public ResponseEntity<InstitutionDTO> institutionRegister(@RequestBody InstitutionDTO dto){
        InstitutionDTO institutionSaved = institutionService.institutionRegister(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(institutionSaved);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> institutionDelete(@PathVariable Long id){
        this.institutionService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<InstitutionDTO> institutionUpdate(@PathVariable Long id, @RequestBody InstitutionDTO dto){
        InstitutionDTO dtoUpdated = institutionService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }
}
