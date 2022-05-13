package lama.activity3.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public boolean CheckCredentials(String surname, String password){
        System.out.println(surname + " et " + password);
        for (Player player : playerRepository.findAll()) {
            if (player.getSurname().compareTo(surname) == 0 && player.getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }


//    public void Register(String name, String surname, String password){
//        Player newUser = new Player(name, surname, password, playerService.GetRandomCards(5), 100);
//        playerRepository.save(newUser);
//    }
//
//    public Long FindByName(String name){
//        return userRepository.findIdByName(name);
//    }
}