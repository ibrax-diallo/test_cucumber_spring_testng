package com.ibrax.controllers;

import com.ibrax.dto.request.ContratDTO;
import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.services.ContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@RestController
@RequestMapping("/api/v1/contrats")
public class ContratController {
    private final ContratService contratService;

    public ContratController(ContratService contratService) {
        this.contratService = contratService;
    }

    @PostMapping("/")
    public ResponseEntity<?> create(@RequestBody ContratDTO contrat) {
        if (contrat == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a contract with empty fields"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(contratService.create(contrat), HttpStatus.OK);
    }
}
