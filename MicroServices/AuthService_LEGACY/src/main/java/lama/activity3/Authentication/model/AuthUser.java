package lama.activity3.Authentication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuthUser {
    @Id
    @GeneratedValue
    private Long userId;
    private String userName;
    private String password;
    private String token;

    public AuthUser() {
    }

    public AuthUser(String userName, String password, String token) {
        this.userName = userName;
        this.password = password;
        this.token = token;
    }

    public AuthUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String user_name) {
        this.userName = user_name;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}