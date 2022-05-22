package lama.activity3.Room;

import lama.activity3.PlayerDTO.PlayerDTO;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PlayerRepository {
    String playerApiUrl = "http://localhost:8080/players";

    public PlayerDTO GetPlayerById(Long playerId) {
        String completeUrl = playerApiUrl + "/" + playerId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PlayerDTO> response = restTemplate.exchange(completeUrl, HttpMethod.GET, null, PlayerDTO.class);
        return response.getBody();
    }
}
