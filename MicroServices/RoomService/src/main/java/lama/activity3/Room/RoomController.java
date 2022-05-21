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

    @GetMapping("/{id}")
    Room one(@PathVariable Long id)
    {
        return repository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PostMapping("/{id}")
    public void CreateRoom(@RequestBody Room room)
    {
        service.CreateRoom(room);
    }

    @PutMapping("/{id]")
    public void JoinRoom(@RequestParam Long roomId, @RequestParam Long guestId)
    {
        service.JoinRoom(roomId, guestId);
    }
}
