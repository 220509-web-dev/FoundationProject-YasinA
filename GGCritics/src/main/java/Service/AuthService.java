package Service;

import dev.GGCritics.Daos.UserDaoPostgres;
import dev.GGCritics.Model.User;
import dtos.Credentials;


public class AuthService {

    private final UserDaoPostgres userDao;

    public AuthService(UserDaoPostgres userDao) {
        this.userDao = userDao;
    }

    public User login(Credentials credentials) {

        // Validate that the credentials provided make sense before trying to query the DB
        if (credentials != null) {
            return userDao.getUserByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
        }
        else
            return null;
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

