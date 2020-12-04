package com.ibrax.entities;

import lombok.Data;


import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
