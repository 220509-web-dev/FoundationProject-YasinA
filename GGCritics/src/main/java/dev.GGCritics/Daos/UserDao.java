package dev.GGCritics.Daos;

import dev.GGCritics.Model.User;

import java.util.List;

public interface UserDao {

// Creates a user
    User createUser(User user);

// Gets user by id
    User getUserById(int id);

//Gets user by username
    User getUserByUsername(String username);

//Gets user by username
    User getUserByUsernameAndPassword(String username, String password);

// Query to get all users and return it as a list
    List<User> getAllUsers();

// Updates a user
    User updateUser(User user);

// Deletes a user by id
    void deleteUserById(int id);
}
