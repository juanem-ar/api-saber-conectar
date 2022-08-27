package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.StudentDTO;

public interface StudentService {
    StudentDTO studentRegister(StudentDTO dto);
    void delete(Long id);
    void isCorrect(Long id);
    StudentDTO getStudentById(Long id);
    StudentDTO update(Long id, StudentDTO dto);
}
