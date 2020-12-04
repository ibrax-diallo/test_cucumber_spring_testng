package com.ibrax.repositories;

import com.ibrax.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
public interface ContratRepository extends JpaRepository<Contrat, Long> {
}
