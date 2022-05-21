package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;

public class RoomService {

    public Room CreateRoom(int bet, PlayerDTO host)
    {
        return new Room(bet, host);
    }

    public void JoinRoom(Room room, PlayerDTO guest)
    {
        room.setGuest(guest);
    }
}
