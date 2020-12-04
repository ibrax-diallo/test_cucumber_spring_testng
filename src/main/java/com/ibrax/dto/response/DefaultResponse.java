package com.ibrax.dto.response;

import lombok.Data;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@university-365.com>
 */
@Data
public class DefaultResponse {

    private String message;

   public DefaultResponse(String message){
       this.message = message;
   }
}
