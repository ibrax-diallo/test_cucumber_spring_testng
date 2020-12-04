package com.ibrax.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
public class MouvementDTO {

    private String typeMod;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dateMod;

    private String nouVal;

    private String AnVal;

    private Long contrat;

    private Long abonne;
}
