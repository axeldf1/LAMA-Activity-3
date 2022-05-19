package lama.activity3.Market.repositories;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PlayerRepository {
    String playerApiUrl = "http://localhost:8081/players";

    public PlayerDTO GetPlayer(int playerId) {
        String completeUrl = playerApiUrl + "/" + playerId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlayerDTO> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, PlayerDTO.class);
        return response.getBody();
    }

    public void putPlayer(PlayerDTO player) {
        String completeUrl = playerApiUrl + "/" + player.getId();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<PlayerDTO> requestUpdate = new HttpEntity<>(player);
        restTemplate.exchange(completeUrl, HttpMethod.PUT, requestUpdate, Void.class);
    }
}
