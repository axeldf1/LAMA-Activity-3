package lama.activity3.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    public void JoinRoom(Long roomId, Long guestId)
    {
        Room roomToJoin = roomRepository.getById(roomId);
        roomToJoin.setGuestId(guestId);
        roomRepository.save(roomToJoin);
        roomRepository.deleteById(roomId);
    }

    public Room CreateRoom(Room room) {
        return roomRepository.save(room);
    }

    public void DeleteRoom(Long roomId)
    {
        roomRepository.deleteById(roomId);
    }
}
