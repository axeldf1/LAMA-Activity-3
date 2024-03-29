package lama.activity3.Room;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Room {

    @Id
    @GeneratedValue
    private Long id;
    private Long hostId;
    private Long hostCardId;
    private Long guestId;
    private Long guestCardId;
    private int bet;

    public Room() {

    }

    public Room(int bet, Long hostId) {
        this.bet = bet;
        this.hostId = hostId;
        this.guestId = null;
    }

    public Long getHostCardId() {
        return hostCardId;
    }

    public void setHostCardId(Long hostCardId) {
        this.hostCardId = hostCardId;
    }

    public Long getGuestCardId() {
        return guestCardId;
    }

    public void setGuestCardId(Long guestCardId) {
        this.guestCardId = guestCardId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guest) {
        this.guestId = guest;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
}
