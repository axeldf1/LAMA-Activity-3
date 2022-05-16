package lama.activity3.Player;

import lama.activity3.Player.Repositories.CardRepository;
import lama.activity3.Player.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private CardRepository cardRepository;

    public boolean CheckCredentials(String surname, String password) {
        for (Player player : playerRepository.findAll()) {
            if (player.getSurname().compareTo(surname) == 0 && player.getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }

    public void Register(String name, String surname, String password) {
        Player newUser = new Player(name, surname, password, cardRepository.GetRandomCards(5), 100);
        playerRepository.save(newUser);
    }

    public Long FindByName(String name) {
        return playerRepository.findIdByName(name);
    }
}