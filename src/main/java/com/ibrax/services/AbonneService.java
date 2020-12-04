package com.ibrax.services;

import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.entities.Abonne;
import com.ibrax.repositories.AbonneRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class AbonneService {

    final AbonneRepository abonneRepository;

    public AbonneService(AbonneRepository abonneRepository) {
        this.abonneRepository = abonneRepository;
    }

    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(abonneRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> create(Abonne entity) {
        if (entity == null || entity.getAdresse() == null || entity.getAdresse().isEmpty() ||
                entity.getNom() == null || entity.getNom().isEmpty() || entity.getPrenom() == null || entity.getPrenom().isEmpty()) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a subscriber with empty fields"), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(abonneRepository.save(entity), HttpStatus.OK);
    }


    public ResponseEntity<?> findPage(Pageable pageable) {
        return new ResponseEntity<>(abonneRepository.findAll(pageable), HttpStatus.OK);
    }

    public ResponseEntity<?> find(final Long id) {
        if (id == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot retrieve an object with a null ID"), HttpStatus.BAD_REQUEST);
        }
        Abonne object = abonneRepository.findById(id).orElse(null);
        if (object == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(object, HttpStatus.OK);

    }

    public ResponseEntity<?> update(Long id, Abonne entity) {
        if (id == null || entity == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot update a subscriber with null id and entity"), HttpStatus.BAD_REQUEST);
        }
        Abonne saved = abonneRepository.findById(id).orElse(null);
        if (saved == null) {
            return ResponseEntity.notFound().build();
        }
        entity.setId(id);
        return new ResponseEntity<>(abonneRepository.save(entity), HttpStatus.OK);
    }
}
