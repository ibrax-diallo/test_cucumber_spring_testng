package com.ibrax.services;

import com.ibrax.dto.request.ContratDTO;
import com.ibrax.entities.Abonne;
import com.ibrax.entities.Contrat;
import com.ibrax.repositories.AbonneRepository;
import com.ibrax.repositories.ContratRepository;
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

    public Contrat create(ContratDTO entity) {
        Abonne abonne = abonneRepository.findById(entity.getAbonne()).orElse(null);
        Contrat contrat = new Contrat();
        contrat.setAbonne(abonne);
        contrat.setAdresse(entity.getAdresse());
        return contratRepository.save(contrat);
    }

}
