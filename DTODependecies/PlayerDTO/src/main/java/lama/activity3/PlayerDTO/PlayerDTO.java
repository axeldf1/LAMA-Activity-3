package lama.activity3.PlayerDTO;

import java.util.List;

public class PlayerDTO {

    private Long id;
    //    private String name;
//    private String surname;
//    private String password;
    private List<Long> cardList;
    private int money;

    public PlayerDTO() {
    }

    public PlayerDTO(List<Long> cardList, int money) {
//        this.name = name;
//        this.surname = surname;
//        this.password = password;
        this.cardList = cardList;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", password='" + password + '\'' +
                ", cardList=" + cardList +
                ", money=" + money +
                '}';
    }

    public Long getId() {
        return id;
    }

    public List<Long> getCardList() {
        return cardList;
    }

    public void setCardList(List<Long> cardList) {
        this.cardList = cardList;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
