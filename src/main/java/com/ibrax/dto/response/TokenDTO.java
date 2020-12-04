package com.ibrax.dto.response;


import lombok.Data;

import java.io.Serializable;


/**
 * @author Ibrahima Diallo <ibrahima.diallo2@supinfo.com>
 */
@Data
public class TokenDTO implements Serializable {

    private static final long serialVersionUID = 6710061358371752955L;

    private Long id;

    private String username;

}
