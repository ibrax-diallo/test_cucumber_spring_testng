package com.ibrax.services;

import com.ibrax.dto.request.LoginDTO;
import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.dto.response.TokenDTO;
import com.ibrax.entities.User;
import com.ibrax.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<?> create(User user) {
        if (user == null || user.getUsername() == null || user.getUsername().isEmpty() ||
                user.getPassword() == null || user.getPassword().isEmpty()) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a user with empty fields"), HttpStatus.BAD_REQUEST);
        }
        User saved = userRepository.save(user);
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUsername(saved.getUsername());
        tokenDTO.setId(saved.getId());
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
    }

    public ResponseEntity<?> login(LoginDTO loginDTO) {
        if (loginDTO == null || loginDTO.getUsername() == null || loginDTO.getUsername().isEmpty() ||
                loginDTO.getPassword() == null || loginDTO.getPassword().isEmpty()) {
            return new ResponseEntity<>(new DefaultResponse("Cannot retrieve a user with empty fields"), HttpStatus.BAD_REQUEST);
        }
        User user = userRepository.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUsername(user.getUsername());
        tokenDTO.setId(user.getId());
        return new ResponseEntity<>(tokenDTO, HttpStatus.OK);
    }
}
