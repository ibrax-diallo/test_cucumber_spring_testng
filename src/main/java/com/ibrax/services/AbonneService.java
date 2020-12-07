package com.ibrax.services;

import com.ibrax.entities.Abonne;
import com.ibrax.repositories.AbonneRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Service
public class AbonneService {

    final AbonneRepository abonneRepository;

    public AbonneService(AbonneRepository abonneRepository) {
        this.abonneRepository = abonneRepository;
    }

    public List<Abonne> findAll() {
        return abonneRepository.findAll();
    }

    public Abonne create(Abonne entity) {
        return abonneRepository.save(entity);
    }


    public Page<Abonne> findPage(Pageable pageable) {
        return abonneRepository.findAll(pageable);
    }

    public Abonne find(final Long id) {
        return abonneRepository.findById(id).orElse(null);

    }

    public Abonne update(Long id, Abonne entity) {
        Abonne saved = abonneRepository.findById(id).orElse(null);
        if (saved == null) {
            return null;
        }
        entity.setId(id);
        return abonneRepository.save(entity);
    }
}
