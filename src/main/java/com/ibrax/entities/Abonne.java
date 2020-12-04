package com.ibrax.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
@Entity
@Table
public class Abonne extends BaseEntity {

    private String nom;

    private String prenom;

    private String adresse;

}
