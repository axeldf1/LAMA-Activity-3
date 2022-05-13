package lama.activity3.Authentication;

import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;
    @Autowired
    AuthRepository authRepository;

    @GetMapping("/login")
    String login() {
        return "login";
    }

    /*@PostMapping("/login")
    String connection(String surname, String password, HttpSession session) {
        if (authService.CheckCredentials(surname, password)) {
            authRepository.save(new AuthUser(session.getId(), userService.FindByName(surname)));
            return "/menu";
        } else
            return "/login";
    }*/

    @GetMapping("/register")
    String register() {
        return "register";
    }
}