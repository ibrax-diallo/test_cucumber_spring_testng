package com.ibrax.controllers;

import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.entities.Abonne;
import com.ibrax.services.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */

@RestController
@RequestMapping("/api/v1/abonne")
public class AbonneController {
    @Autowired
    private final AbonneService abonneService;

    public AbonneController(AbonneService abonneService) {
        this.abonneService = abonneService;
    }

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(abonneService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity findPage(Pageable pageable) {
        return new ResponseEntity<>(abonneService.findPage(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(name = "id") Long id) {
        if (id == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot retrieve an object with a null ID"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(abonneService.find(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Abonne entity) {
        if (entity == null || entity.getAdresse() == null || entity.getAdresse().isEmpty() ||
                entity.getNom() == null || entity.getNom().isEmpty() || entity.getPrenom() == null || entity.getPrenom().isEmpty()) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a subscriber with empty fields"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(abonneService.create(entity), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody Abonne entity) {
        if (id == null || entity == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot update a subscriber with null id and entity"), HttpStatus.BAD_REQUEST);
        }
        Abonne abonne = abonneService.update(id, entity);
        return new ResponseEntity<>(abonne, HttpStatus.OK);
    }

}
