package lama.activity3.Room;

public class RoomNotFoundException extends RuntimeException {
    public RoomNotFoundException(Long id) {
        super("Could not find room " + id);
    }
}
