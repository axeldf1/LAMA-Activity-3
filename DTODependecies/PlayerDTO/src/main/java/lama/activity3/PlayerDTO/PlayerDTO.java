package lama.activity3.PlayerDTO;

import lama.activity3.CardDTO.Card;

import java.util.List;

public class PlayerDTO {

    private Long id;
    private String name;
    private String surname;
    private String password;
    private List<Long> cardList;
    private int money;

    public PlayerDTO() {
    }

    public PlayerDTO(String name, String surname, String password, List<Long> cardList, int money) {
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public List<Long> getCardList() {
        return cardList;
    }

    public int getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCardList(List<Long> cardList) {
        this.cardList = cardList;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
