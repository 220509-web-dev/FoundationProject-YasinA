// Packages
package dev.GGCritics.Model;

public class User {

    private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;

    public User() {}
        public User(int userId, String firstName, String lastName, String email, String username, String password) {
            this.userId = userId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.username = username;
            this.password = password;
        }
// Getters and setters for user id
    public int getUserId() {
            return userId;
        }

    public void setUserId(int userId) {
            this.userId = userId;
        }

// Getters and setter for firstname
    public String getFirstName() {
            return firstName;
        }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
        }

// Getters and setter for lastname
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

// Getters and setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

// Getters and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

// Getters and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username'" + username + '\'' +
                ", password'" + password + '\'' +
                '}';
    }
}

