package com.ibrax.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
@Entity
@Table
public class Mouvement extends BaseEntity {

    private String typeMod;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateMod;

    private String nouVal;

    private String AnVal;

    @ManyToOne
    private Contrat contrat;

    @ManyToOne
    private Abonne abonne;


}
