package com.mukhtarov.security_new.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 'Mukhtarov Sarvarbek' on 06.12.2022
 * @project security_new
 * @contact @sarvargo
 */

@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello guys!!");
    }

    @GetMapping("/say-good-bye")
    public ResponseEntity<String> sayGooBye() {
        return ResponseEntity.ok("Good bye see you never!");
    }
}
