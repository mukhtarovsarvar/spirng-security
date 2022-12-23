package com.mukhtarov.security_new.controllers;

import com.mukhtarov.security_new.config.util.JwtUtils;
import com.mukhtarov.security_new.dao.UserDao;
import com.mukhtarov.security_new.dto.AuthDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 'Mukhtarov Sarvarbek' on 10.12.2022
 * @project security_new
 * @contact @sarvargo
 */
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final UserDao userDao;

    private final JwtUtils jwtUtils;

    @PostMapping("")
    public ResponseEntity<String> authenticate(
            @RequestBody AuthDTO request
    ) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken
                        (
                                request.getUsername(),
                                request.getPassword()
                        )
        );

        final UserDetails user = this.userDao.findByUsername(request.getUsername());

        if (user != null) return ResponseEntity.ok(jwtUtils.generateToken(user));

        return ResponseEntity.status(400).body("Some error!");

    }
}
