package lama.activity3.Market.repositories;

import lama.activity3.CardDTO.Card;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PlayerRepository {
    String playerApiUrl = "http://localhost:8081/players";

    public Card GetCard(int cardID) {
        String completeUrl = playerApiUrl + "/" + cardID;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Card> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, Card.class);
        return response.getBody();
    }
}
