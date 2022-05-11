package lama.activity3.Room;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @GetMapping("/")
    public String Index() {
        return "You are on the Room microservice";
    }
}
