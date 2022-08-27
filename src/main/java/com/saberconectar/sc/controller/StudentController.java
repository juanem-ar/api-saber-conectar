package com.saberconectar.sc.controller;

import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudentById(@PathVariable Long id){
        StudentDTO student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(student);
    }
    @PostMapping
    public ResponseEntity<StudentDTO> studentRegister(@RequestBody StudentDTO dto){
        StudentDTO studentSaved = studentService.studentRegister(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentSaved);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> studentDelete(@PathVariable Long id){
        this.studentService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> studentUpdate(@PathVariable Long id, @RequestBody StudentDTO dto){
        StudentDTO dtoUpdated = studentService.update(id, dto);
        return ResponseEntity.ok().body(dtoUpdated);
    }
}
