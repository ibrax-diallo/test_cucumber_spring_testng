package com.ibrax.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Ibrahima Diallo <ibrahima.diallo2@supinfo.com>
 */

@Data
public class LoginDTO implements Serializable {

    private static final long serialVersionUID = -4159366809929151486L;

    private String username;

    private String password;

    public LoginDTO() {
    }

}
