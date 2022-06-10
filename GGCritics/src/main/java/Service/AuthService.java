package Service;

import dev.GGCritics.Daos.UserDaoPostgres;
import dev.GGCritics.Model.User;
import dtos.Credentials;

import java.util.ArrayList;
import java.util.List;


public class AuthService {

    private final UserDaoPostgres userDao;

    public AuthService(UserDaoPostgres userDao) {
        this.userDao = userDao;
    }

    public User login(Credentials credentials) {
        User user;

        if (credentials != null) {
            user = userDao.getUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        }
        else {
            user = null;
        }
    return user;
    }

    public User register(User user) {
        if (user.getFirstName() != null && user.getLastName() != null && user.getEmail() != null && user.getPassword() != null) {
            userDao.createUser(user);
            if(user.getUserId() > 0) {
                System.out.println("Registered successfully!");
            }
            return user;
        } else {
            System.out.println("Cannot have an empty field!!!");
        }
        return user;
    }

}

