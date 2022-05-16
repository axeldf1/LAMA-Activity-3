package lama.activity3.Player;

import lama.activity3.Player.Exceptions.PlayerNotFoundException;
import lama.activity3.Player.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository repository;

//    @Autowired
//    private CardRepository CardRepository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

//    TODO : requestBody
    @PostMapping("/players")
    void newPlayer(String name, String surname, String password) {
        playerService.Register(name, surname, password);
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/players/{id}")
    Player replaceUser(@RequestBody Player newPlayer, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newPlayer.getName());
                    user.setMoney(newPlayer.getMoney());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return repository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }

//    @GetMapping("/test/{amount}")
//    Card[] test(@PathVariable int amount){return CardRepository.GetRandomCards(amount);}

}
