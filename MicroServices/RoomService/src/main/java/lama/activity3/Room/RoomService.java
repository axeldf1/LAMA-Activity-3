package lama.activity3.Room;

import org.springframework.stereotype.Service;

@Service
public class RoomService {

    public void JoinRoom(Room room, Long guest)
    {
        room.setGuestId(guest);
    }
}
