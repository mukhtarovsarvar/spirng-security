package com.mukhtarov.security_new.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author 'Mukhtarov Sarvarbek' on 10.12.2022
 * @project security_new
 * @contact @sarvargo
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthDTO {

    private String username;

    private String password;
}
