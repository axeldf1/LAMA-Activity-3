package lama.activity3.Game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    GameService service;

    @GetMapping("/")
    public Long CompareCards(@RequestParam Long hostCardId, @RequestParam Long guestCardId)
    {
        return service.CompareCards(hostCardId, guestCardId);
    }
}
