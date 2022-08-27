package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.StudentDTO;

public interface StudentService {
    public StudentDTO studentRegister(StudentDTO dto);
    public void delete(Long id);

    void isCorrect(Long id);

    StudentDTO getStudentById(Long id);

    StudentDTO update(Long id, StudentDTO dto);
}
