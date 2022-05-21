package lama.activity3.Player.Repositories;

import lama.activity3.CardDTO.Card;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CardRepository {
    String cardApiUrl = "http://localhost:8080/cards";

    public Card GetCard(int cardID) {
        String completeUrl = cardApiUrl + "/" + cardID;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Card> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, Card.class);
        return response.getBody();
    }

    public Card[] GetRandomCards(int amount) {
        String completeUrl = cardApiUrl + "/random/" + amount;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Card[]> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, Card[].class);
        return response.getBody();
    }
}
