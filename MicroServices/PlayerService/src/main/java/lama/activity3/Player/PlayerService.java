package lama.activity3.Player;

import lama.activity3.CardDTO.Card;
import lama.activity3.Player.Repositories.CardRepository;
import lama.activity3.Player.Repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        List<Long> cardsID= new ArrayList<Long>();
        Card[] cards = cardRepository.GetRandomCards(5);
        for(int i = 0; i < 5; i++){
            cardsID.add(cards[i].getId());
        }
        Player newUser = new Player(name, surname, password, cardsID, 100);
        playerRepository.save(newUser);
    }

    public Long FindByName(String name) {
        return playerRepository.findIdByName(name);
    }
}