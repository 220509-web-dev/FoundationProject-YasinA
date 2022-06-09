package Service;

import dev.GGCritics.Model.User;
import dev.GGCritics.Daos.UserDaoPostgres;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class UserService {

    private final UserDaoPostgres userDao;

    public UserService(UserDaoPostgres userDao) {
        this.userDao = userDao;
    }
    public User getUserByUsername(String username) {
        try {
        if (username != null) {
            return userDao.getUserByUsername(username);
        }}
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(String id) {
        try {
            if (id != null) {
                return userDao.getUserById(parseInt(id));
            }}
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
