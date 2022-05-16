package lama.activity3.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping("/users")
    void newUser(String name, String surname, String password) {
        playerService.Register(name, surname, password);
    }

    @GetMapping("/users/{id}")
    Player one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/users/{id}")
    Player replaceUser(@RequestBody Player newUser, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setMoney(newUser.getMoney());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
