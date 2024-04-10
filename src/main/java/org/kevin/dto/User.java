package org.kevin.dto;

public class User {
    private String userName;
    private String password;
    private boolean isLibrarian;
    private boolean isLoggedIn;

    public User(String userName, String password, boolean isLibrarian, boolean isLoggedIn) {
        this.userName = userName;
        this.password = password;
        this.isLibrarian = isLibrarian;
        this.isLoggedIn = isLoggedIn;
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

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public void setLibrarian(boolean librarian) {
        isLibrarian = librarian;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isLibrarian=" + isLibrarian +
                ", isLoggedIn=" + isLoggedIn +
                '}';
    }
}
