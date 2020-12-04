package com.ibrax.repositories;

import com.ibrax.entities.Abonne;
import com.ibrax.entities.Mouvement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public interface MouvementRepository extends JpaRepository<Mouvement, Long> {
    List<Mouvement> findByAbonne(Abonne abonne);
}
