package lama.activity3.Player;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Player {
    @Id
    private Long id;
    //    @Column(unique = true)
//    private String name;
//    private String surname;
//    private String password;
    @ElementCollection
    private List<Long> CardIdCollection;
    private int money;

    public Player() {
    }

    public Player(Long id, List<Long> CardIdCollection, int money) {
        this.id = id;
        this.CardIdCollection = CardIdCollection;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", cardList=" + CardIdCollection +
                ", money=" + money +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getCardList() {
        return CardIdCollection;
    }

    public void setCardList(List<Long> CardIdCollection) {
        this.CardIdCollection = CardIdCollection;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void takeMoney(int amount) {
        this.money -= amount;
    }

    public void giveMoney(int amount) {
        this.money += amount;
    }
}