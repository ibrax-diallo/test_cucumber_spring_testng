package com.ibrax.controllers;

import com.ibrax.dto.request.MouvementDTO;
import com.ibrax.services.MouvementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@RestController
@RequestMapping( "/api/v1/mouvements")
public class MouvementController {
    private final MouvementService mouvementService;

    public MouvementController(MouvementService mouvementService) {
        this.mouvementService = mouvementService;
    }

    @PostMapping("/")
    public ResponseEntity create(@RequestBody MouvementDTO mouvement) {
        return mouvementService.create(mouvement);
    }

    @GetMapping("/abonne/{id}")
    public ResponseEntity getMouvByAbonne(@PathVariable(name = "id") Long id) {
        return mouvementService.getMouvByAbonne(id);
    }
}
