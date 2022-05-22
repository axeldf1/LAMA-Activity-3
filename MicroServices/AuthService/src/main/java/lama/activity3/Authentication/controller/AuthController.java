package lama.activity3.Authentication.controller;

import lama.activity3.AuthDTO.AuthDTO;
import lama.activity3.Authentication.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String userName, @RequestBody String password) {
        return authService.login(userName, password);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AuthDTO user) {
        authService.register(user);
        return new ResponseEntity<String>("Registered", HttpStatus.OK);
    }
}