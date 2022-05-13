package lama.activity3.Player;

import lama.activity3.CardDTO.Card;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CardRepository {
    String cardApiUrl = "http://localhost:8085/cards/1";

    public Card GetCard(Long cardID) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Card> response = restTemplate.exchange(cardApiUrl, HttpMethod.GET, null, Card.class);
        return response.getBody();
    }
}
