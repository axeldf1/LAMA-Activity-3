package lama.activity3.Authentication.repository;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PlayerRepository {
    String playerApiUrl = "http://localhost:8080/players";

    public void createPlayer(Long userId) {
        String completeUrl = playerApiUrl + "?id=" + userId;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(completeUrl, HttpMethod.POST, null, Void.class);
    }
}
