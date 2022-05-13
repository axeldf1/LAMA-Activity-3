package lama.activity3.Player;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(Long id) {
        super("Could not find user " + id);
    }
}
