package lama.activity3.Player;

import lama.activity3.Player.Exceptions.PlayerNotFoundException;
import lama.activity3.Player.Repositories.PlayerRepository;
import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerRepository repository;

    PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    List<Player> all() {
        return repository.findAll();
    }

    @PostMapping()
    void newPlayer(@RequestParam Long id) {
        playerService.Register(id);
    }

    @GetMapping("/{id}")
    Player one(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @PutMapping("/{id}")
    Player replaceUser(@RequestBody PlayerDTO newPlayer, @PathVariable Long id) {
        System.out.println(newPlayer);
        return repository.findById(id)
                .map(user -> {
//                    user.setName(newPlayer.getName());
//                    user.setSurname(newPlayer.getSurname());
                    user.setMoney(newPlayer.getMoney());
                    user.setCardList(newPlayer.getCardList());
//                    user.setCardList(newPlayer.getCardIdList());
                    return repository.save(user);
                })
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
