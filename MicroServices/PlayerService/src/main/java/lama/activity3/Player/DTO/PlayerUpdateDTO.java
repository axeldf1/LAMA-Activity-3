package lama.activity3.Player.DTO;

import java.util.List;

public class PlayerUpdateDTO {
    String name;
    String surname;
    String password;
    int money;
    List<Long> cardIdList;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public List<Long> getCardIdList() {
        return cardIdList;
    }
}
