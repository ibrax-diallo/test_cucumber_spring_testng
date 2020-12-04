package com.ibrax.services;

import com.ibrax.dto.request.MouvementDTO;
import com.ibrax.dto.response.DefaultResponse;
import com.ibrax.entities.Abonne;
import com.ibrax.entities.Contrat;
import com.ibrax.entities.Mouvement;
import com.ibrax.repositories.AbonneRepository;
import com.ibrax.repositories.ContratRepository;
import com.ibrax.repositories.MouvementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class MouvementService {
    private final MouvementRepository mouvementRepository;
    private final AbonneRepository abonneRepository;
    private final ContratRepository contratRepository;

    public MouvementService(MouvementRepository mouvementRepository, AbonneRepository abonneRepository, ContratRepository contratRepository) {
        this.mouvementRepository = mouvementRepository;
        this.abonneRepository = abonneRepository;
        this.contratRepository = contratRepository;
    }

    public ResponseEntity<?> create(MouvementDTO entity) {
        if (entity == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot retrieve an object with a null ID"), HttpStatus.BAD_REQUEST);
        }
        Abonne abonne = abonneRepository.findById(entity.getAbonne()).orElse(null);
        Contrat contrat = contratRepository.findById(entity.getContrat()).orElse(null);
        if (abonne == null || contrat == null) {
            return ResponseEntity.notFound().build();
        }
        Mouvement mouvement = new Mouvement();
        mouvement.setAbonne(abonne);
        mouvement.setContrat(contrat);
        mouvement.setAnVal(entity.getAnVal());
        mouvement.setNouVal(entity.getNouVal());
        mouvement.setDateMod(entity.getDateMod());
        mouvement.setTypeMod(entity.getTypeMod());

        return new ResponseEntity<>(mouvementRepository.save(mouvement), HttpStatus.OK);
    }

    public ResponseEntity<?> getMouvByAbonne(Long id) {
        if (id == null) {
            return new ResponseEntity<>(new DefaultResponse("Cannot retrieve an object with a null ID"), HttpStatus.BAD_REQUEST);
        }
        Abonne abonne = abonneRepository.findById(id).orElse(null);
        if (abonne == null) {
            return ResponseEntity.notFound().build();
        }
        List<Mouvement> mouvements = mouvementRepository.findByAbonne(abonne);
        return new ResponseEntity<>(mouvements, HttpStatus.OK);

    }
}
