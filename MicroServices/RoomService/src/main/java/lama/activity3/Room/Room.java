package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private PlayerDTO host;
    private PlayerDTO guest;
    private int bet;

    public Room()
    {

    }

    public Room(int bet, PlayerDTO host)
    {
        this.bet = bet;
        this.host = host;
        this.guest = null;
    }

    public void setGuest(PlayerDTO guest) {
        this.guest = guest;
    }

    public Long getId()
    {
        return this.id;
    }
}
