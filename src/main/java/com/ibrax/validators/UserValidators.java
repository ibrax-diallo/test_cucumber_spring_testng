package com.ibrax.validators;

import com.ibrax.entities.User;
import com.ibrax.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class UserValidators {

    private final UserRepository userRepository;

    @Autowired
    public UserValidators(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String create(User dto) {
        if (dto.getUsername() == null || dto.getUsername().isEmpty() ||
                dto.getPassword() == null | dto.getPassword().isEmpty()) {
            return "Un compte est déjà associé à cette adresse email";
        }
        if (userRepository.existsByUsername(dto.getUsername())) {
            return "Un compte est déjà associé à cette adresse email";
        }
        if (dto.getPassword().length() <= 5) {
            return "Le champ du mot de passe doit contenir au moins 5 caractères";
        }
        if (dto.getPassword().length() > 45) {
            return "Le champ du mot de passe ne peut pas contenir plus de 45 caractères";
        }
        return null;
    }

}
