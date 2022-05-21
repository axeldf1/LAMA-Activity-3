package lama.activity3.Authentication.service;

import lama.activity3.AuthDTO.AuthDTO;
import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import lama.activity3.Authentication.repository.PlayerRepository;
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
    @Autowired
    PlayerRepository playerRepository;

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

    public void register(AuthDTO newPlayer) {
        AuthUser player = new AuthUser(newPlayer.getUserName(), newPlayer.getPassword());
        authRepository.save(player);
        System.out.println(player);
        playerRepository.createPlayer(player.getUserId());
    }

    public Optional<User> findByToken(String token) {
        Optional<AuthUser> player = authRepository.findByToken(token);
        if (player.isPresent()) {
            AuthUser player1 = player.get();
            User user = new User(player1.getUserName(), player1.getPassword(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public AuthUser findById(Long id) {
        Optional<AuthUser> player = authRepository.findById(id);
        return player.orElse(null);
    }
}
