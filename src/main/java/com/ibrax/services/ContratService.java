package com.ibrax.services;

import com.ibrax.dto.request.ContratDTO;
import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.entities.Abonne;
import com.ibrax.entities.Contrat;
import com.ibrax.repositories.AbonneRepository;
import com.ibrax.repositories.ContratRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class ContratService {

    final private ContratRepository contratRepository;

    final private AbonneRepository abonneRepository;

    public ContratService(ContratRepository contratRepository, AbonneRepository abonneRepository) {
        this.contratRepository = contratRepository;
        this.abonneRepository = abonneRepository;
    }

    public ResponseEntity<?> create(ContratDTO entity) {
        if (entity == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a contract with empty fields"), HttpStatus.BAD_REQUEST);
        }
        Abonne abonne = abonneRepository.findById(entity.getAbonne()).orElse(null);
        if (abonne == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot create a contract with empty fields"), HttpStatus.BAD_REQUEST);
        }
        Contrat contrat = new Contrat();
        contrat.setAbonne(abonne);
        contrat.setAdresse(entity.getAdresse());
        return new ResponseEntity<>(contratRepository.save(contrat), HttpStatus.OK);
    }

}
