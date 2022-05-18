package lama.activity3.Market.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Offer {

    int playerId;
    int cardId;
    int price;
    int quantity;
    @Id
    @GeneratedValue
    private Long id;

    public Offer() {
    }

    public Offer(int player, int card, int price, int quantity) {
        this.playerId = player;
        this.cardId = card;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
