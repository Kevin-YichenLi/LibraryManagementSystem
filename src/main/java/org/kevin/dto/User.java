package org.kevin.dto;

/**
 * User class
 *
 * @author Kevin-Yichen Li
 */
public class User {
    private int id;
    private String userName;
    private String password;
    private String status;

    public User(String userName, String password, String status) {
        this.userName = userName;
        this.password = password;
        this.status = status;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User() {};

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
