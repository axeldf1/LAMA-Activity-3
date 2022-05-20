package lama.activity3.Authentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuthUser {
    @Id
    @GeneratedValue
    private Long userId;
    private String user_name;
    private String password;
    private String token;

    public AuthUser() {
    }

    public AuthUser(String user_name, String password, String token) {
        this.user_name = user_name;
        this.password = password;
        this.token = token;
    }

    public AuthUser(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}