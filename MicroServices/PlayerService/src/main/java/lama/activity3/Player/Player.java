package lama.activity3.Player;

import lama.activity3.CardDTO.Card;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Player {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private String surname;
    private String password;
    private transient Card[] cardList;
    private int money;

    public Player() {
    }

    public Player(String name, String surname, String password, Card[] cardList, int money) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.cardList = cardList;
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
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

    public Card[] getCardList() {
        return cardList;
    }

    public void setCardList(Card[] cardList) {
        this.cardList = cardList;
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