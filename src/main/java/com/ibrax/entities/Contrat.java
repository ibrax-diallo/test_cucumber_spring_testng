package com.ibrax.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
@Entity
@Table
public class Contrat extends BaseEntity {

    private String adresse;

    @ManyToOne
    @JoinColumn
    private Abonne abonne;


}
