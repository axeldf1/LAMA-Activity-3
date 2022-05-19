package lama.activity3.Player.Exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
