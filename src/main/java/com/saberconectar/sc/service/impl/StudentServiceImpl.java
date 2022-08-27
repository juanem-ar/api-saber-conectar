package com.saberconectar.sc.service.impl;

import com.saberconectar.sc.dto.StudentDTO;
import com.saberconectar.sc.entity.StudentEntity;
import com.saberconectar.sc.exception.ParamNotFound;
import com.saberconectar.sc.mapper.StudentMapper;
import com.saberconectar.sc.repository.StudentRepository;
import com.saberconectar.sc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentMapper studentMapper;

    public StudentDTO studentRegister(StudentDTO dto) {
        StudentEntity entity = studentMapper.studentDTO2Entity(dto);
        StudentEntity entitySaved = studentRepository.save(entity);
        StudentDTO result = studentMapper.studentEntity2DTO(entitySaved);
        return result;

    }

    public void delete(Long id) {
        isCorrect(id);
        this.studentRepository.deleteById(id);
    }

    public StudentDTO getStudentById(Long id) {
        isCorrect(id);
        StudentEntity entity = studentRepository.getReferenceById(id);
        StudentDTO dto = studentMapper.studentEntity2DTO(entity);
        return dto;
    }
    public StudentDTO update(Long id, StudentDTO student) {
        isCorrect(id);
        StudentEntity entityId = studentRepository.getReferenceById(id);
        StudentEntity entity = studentMapper.update(entityId, student);
        StudentEntity entityUpdated = studentRepository.save(entity);
        StudentDTO dto = studentMapper.studentEntity2DTO(entityUpdated);
        return dto;
    }
    public void isCorrect(Long id){
        if(!studentRepository.existsById(id)){
            throw new ParamNotFound("Invalid id");
        }
    }
}
