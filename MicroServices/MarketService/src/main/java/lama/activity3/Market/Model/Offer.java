package lama.activity3.Market.Model;

import lama.activity3.CardDTO.Card;
import lama.activity3.PlayerDTO.PlayerDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {

    //    @OneToOne(fetch = FetchType.EAGER)
    transient PlayerDTO player;
    //    @OneToOne(fetch = FetchType.EAGER)
    transient Card card;
    int price;
    int quantity;
    @Id
    @GeneratedValue
    private Long id;

    public Offer() {
    }

    public Offer(PlayerDTO player, Card card, int price, int quantity) {
        this.player = player;
        this.card = card;
        this.price = price;
        this.quantity = quantity;
    }

    public PlayerDTO getPlayer() {
        return player;
    }

    public Card getCard() {
        return card;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getId() {
        return id;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
