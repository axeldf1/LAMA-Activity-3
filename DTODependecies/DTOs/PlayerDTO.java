package lama.activity-3.DTOs;

public class PlayerDTO {
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public int getMoney()
    {
        return this.money;
    }
}