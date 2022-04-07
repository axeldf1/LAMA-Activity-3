package lama.activity-3.Player;

import javax.persistence.*;
import java.util.List;

@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String surname;
    private String password;
    @ManyToMany
    private List<Card> cardList;
    private int money;

    public Player() {
    }

    public Player(String name, String surname, String password, List<Card> cardList, int money) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.cardList = cardList;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", cardList=" + cardList +
                ", money=" + money +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public int getMoney()
    {
        return this.money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public void takeMoney(int amount)
    {
        this.money -= amount;
    }

    public void giveMoney(int amount)
    {
        this.money += amount;
    }
}
