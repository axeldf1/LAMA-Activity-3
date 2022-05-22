package lama.activity3.Authentication.service;

import lama.activity3.AuthDTO.AuthDTO;
import lama.activity3.Authentication.model.AuthUser;
import lama.activity3.Authentication.repository.AuthRepository;
import lama.activity3.Authentication.repository.PlayerRepository;
import lama.activity3.Authentication.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    AuthRepository authRepository;
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    private JwtUtil jwtUtil;

    public ResponseEntity<String> login(String userName, String password) {
        if (authRepository.login(userName, password).isPresent())
            return new ResponseEntity<String>("", HttpStatus.FORBIDDEN);
        return new ResponseEntity<String>(jwtUtil.generateToken(userName), HttpStatus.OK);
    }

    public void register(AuthDTO newPlayer) {
        AuthUser player = new AuthUser(newPlayer.getUserName(), newPlayer.getPassword());
        authRepository.save(player);
        playerRepository.createPlayer(player.getUserId());
    }

//    public Optional<User> findByToken(String token) {
//        Optional<AuthUser> player = authRepository.findByToken(token);
//        if (player.isPresent()) {
//            AuthUser player1 = player.get();
//            User user = new User(player1.getUserName(), player1.getPassword(), true, true, true, true,
//                    AuthorityUtils.createAuthorityList("USER"));
//            return Optional.of(user);
//        }
//        return Optional.empty();
//    }

    public AuthUser findById(Long id) {
        Optional<AuthUser> player = authRepository.findById(id);
        return player.orElse(null);
    }
}
