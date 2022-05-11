package lama.activity3.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CardService service;

    public boolean CheckCredentials(String surname, String password){
        System.out.println(surname + " et " + password);
        for (User user : userRepository.findAll()) {
            if (user.getSurname().compareTo(surname) == 0 && user.getPassword().compareTo(password) == 0) {
                return true;
            }
        }
        return false;
    }

    public void Register(String name, String surname, String password){
        User newUser = new User(name, surname, password, service.GetRandomCards(5), 100);
        userRepository.save(newUser);
    }

    public Long FindByName(String name){
        return userRepository.findIdByName(name);
    }
}