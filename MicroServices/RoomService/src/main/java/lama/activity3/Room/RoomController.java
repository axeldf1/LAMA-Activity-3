package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    private final RoomRepository repository;
    @Autowired
    private RoomService service;

    RoomController(RoomRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("/")
    public String Index() {
        return "You are on the Room microservice";
    }

    @GetMapping("/rooms")
    List<Room> all()
    {
        return repository.findAll();
    }

    @PostMapping("/rooms")
            Room newRoom(@RequestBody Room newRoom)
    {
        return repository.save(newRoom);
    }

    @GetMapping("/rooms/{id}")
    Room one(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PostMapping("/rooms/{id}")
    public Room CreateRoom(@RequestBody int bet, @RequestBody PlayerDTO host)
    {
        return repository.save(service.CreateRoom(bet, host));
    }

    @GetMapping("/{id]")
    public String JoinRoom(@RequestBody Room room, @RequestBody PlayerDTO guest)
    {
        service.JoinRoom(room, guest);
        return ("Player has joined Room " + room.getId());
    }
}
