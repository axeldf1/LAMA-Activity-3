package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomRepository repository;
    @Autowired
    private RoomService service;

    RoomController(RoomRepository repository)
    {
        this.repository = repository;
    }

    @GetMapping("")
    List<Room> all()
    {
        return repository.findAll();
    }

    @PostMapping("")
            Room newRoom(@RequestBody Room newRoom)
    {
        return repository.save(newRoom);
    }

    @GetMapping("/{id}")
    Room one(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PostMapping("/{id}")
    public Room CreateRoom(@RequestBody Room room)
    {
        return repository.save(room);
    }

    @GetMapping("/{id]")
    public String JoinRoom(@RequestBody Room room, @RequestBody PlayerDTO guest)
    {
        service.JoinRoom(room, guest);
        return ("Player has joined Room " + room.getId());
    }
}
