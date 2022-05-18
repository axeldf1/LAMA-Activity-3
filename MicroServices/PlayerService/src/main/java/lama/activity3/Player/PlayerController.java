package lama.activity3.Player;

import lama.activity3.Player.DTO.PlayerUpdateDTO;
import lama.activity3.Player.DTO.RegisterDTO;
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

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/players")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping("/players")
    void newPlayer(@RequestBody RegisterDTO registerDTO) {
        playerService.Register(registerDTO.getName(), registerDTO.getSurname(), registerDTO.getPassword());
    }

    @GetMapping("/players/{id}")
    Player one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/players/{id}")
    Player replaceUser(@RequestBody PlayerUpdateDTO newPlayer, @PathVariable Long id) {
        return repository.findById(id)
                .map(user -> {
                    user.setName(newPlayer.getName());
                    user.setSurname(newPlayer.getSurname());
                    user.setMoney(newPlayer.getMoney());
                    user.setCardList(newPlayer.getCardIdList());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    return null;
                });
    }

    @DeleteMapping("/players/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
