package lama.activity3.Authentication.controller;

import lama.activity3.AuthDTO.AuthDTO;
import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import lama.activity3.Authentication.service.AuthService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    AuthRepository authRepository;

    @PostMapping("/auth/register")
    public void register(@RequestBody AuthDTO newUser) {
        authService.register(newUser);
    }

    @PostMapping("/auth/login")
    public String login(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        return authService.checkCredentials(username, password);
    }

    @PostMapping("/auth/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password) {
        String token = authService.login(username, password);
        if (StringUtils.isEmpty(token)) {
            return "no token found";
        }
        return token;
    }

    @GetMapping(value = "/auth/api/user/{id}", produces = "application/json")
    public AuthUser getUserDetail(@PathVariable Long id) {
        return authService.findById(id);
    }
}