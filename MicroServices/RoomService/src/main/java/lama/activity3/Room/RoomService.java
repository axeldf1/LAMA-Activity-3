package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;
    @Autowired
    PlayerRepository playerRepository;

    public void JoinRoom(Long roomId, Long guestId)
    {
        Room roomToJoin = roomRepository.getById(roomId);
        roomToJoin.setGuestId(guestId);

        PlayerDTO player = playerRepository.getById(guestId);
        player.setMoney(player.getMoney() - roomToJoin.getBet());

        roomRepository.save(roomToJoin);
        roomRepository.deleteById(roomId);
    }

    public Room CreateRoom(Room room) {
        PlayerDTO player = playerRepository.getById(room.getHostId());
        player.setMoney(player.getMoney() - room.getBet());
        return roomRepository.save(room);
    }

    public void DeleteRoom(Long roomId)
    {
        roomRepository.deleteById(roomId);
    }

    public void ChooseCard(Long roomId, Long cardId, String who)
    {
        Room currentRoom = roomRepository.getById(roomId);
        switch (who)
        {
            case "HOST":
                currentRoom.setHostCardId(cardId);
                break;
            case "GUEST":
                currentRoom.setGuestCardId(cardId);
                break;
            default:
                return;
        }
        roomRepository.save(currentRoom);
        roomRepository.deleteById(roomId);
    }

    public void GiveBet(Long roomId, Long winnerId)
    {
        Room room = roomRepository.getById(roomId);
        PlayerDTO player = playerRepository.getById(winnerId);
        player.setMoney(player.getMoney() + room.getBet() * 2);
    }
}
