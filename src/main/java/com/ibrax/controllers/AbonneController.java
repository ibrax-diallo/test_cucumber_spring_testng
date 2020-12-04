package com.ibrax.controllers;

import com.ibrax.entities.Abonne;
import com.ibrax.services.AbonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity findAll() {
        return abonneService.findAll();
    }

    @GetMapping("/page")
    public ResponseEntity findPage(Pageable pageable) {
        return abonneService.findPage(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable(name = "id") Long id) {
        return abonneService.find(id);
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody Abonne entity) {
        return abonneService.create(entity);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable(name = "id") Long id, @RequestBody Abonne entity) {
        return abonneService.update(id, entity);
    }

}
