package lama.activity3.Game;

import lama.activity3.CardDTO.Card;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CardRepository {
    String cardApiUrl = "http://localhost:8080/cards";

    public Card GetCard(Long cardID) {
        String completeUrl = cardApiUrl + "/" + cardID;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Card> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, Card.class);
        return response.getBody();
    }
}