package com.saberconectar.sc.service;

import com.saberconectar.sc.dto.UserDTO;


public interface UserService {
    UserDTO save(UserDTO dto);
    UserDTO getUserById(Long id);
    UserDTO update(Long id, UserDTO user);
    void delete (Long id);
    void isCorrect(Long id);
}
