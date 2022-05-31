package dev.GGCritics.Daos;

import dev.GGCritics.Entities.User;

import java.util.List;

public interface UserDao {

// Creates a user
    User createUser(User user);

// Gets user by id
    User getUserById(int id);

// Query to get all users and return it as a list
    List<User> getAllUsers();

// Updates a user
    User updateUser(User user);

// Deletes a user by id
    void deleteUserById(int id);
}
