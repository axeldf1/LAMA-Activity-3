package lama.activity3.Authentication.service;

import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;

    public String login(String username, String password) {
        Optional<AuthUser> player = authRepository.login(username, password);
        if (player.isPresent()) {
            String token = UUID.randomUUID().toString();
            AuthUser custom = player.get();
            custom.setToken(token);
            authRepository.save(custom);
            return token;
        }

        return StringUtils.EMPTY;
    }

    public Optional<User> findByToken(String token) {
        Optional<AuthUser> player = authRepository.findByToken(token);
        if (player.isPresent()) {
            AuthUser player1 = player.get();
            User user = new User(player1.getUser_name(), player1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public AuthUser findById(Long id) {
        Optional<AuthUser> customer = authRepository.findById(id);
        return customer.orElse(null);
    }
}
