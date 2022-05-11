package lama.activity3.Authentication.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthUser {
    @Id
    private String sessionId;
    private Long userId;

    public AuthUser(String sessionId, Long userId) {
        this.sessionId = sessionId;
        this.userId = userId;
    }

    public AuthUser() {

    }

    public Long getUserId() {
        return userId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String id) {
        this.sessionId = id;
    }
}