package dev.GGCritics.App;

import dev.GGCritics.Daos.UserDaoPostgres;
import dev.GGCritics.Model.User;
import dev.GGCritics.Utilities.ConnectionFactoryUtility;
import dev.GGCritics.Daos.UserDao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class App {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = ConnectionFactoryUtility.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(conn);
//
    UserDao userDao = new UserDaoPostgres();
    List<User> allUsers = userDao.getAllUsers();
        System.out.println(allUsers);
//        Game apex = new Game(0, "Apex Legends", "Best battle royale out right now", 8, "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse2.mm.bing.net%2Fth%3Fid%3DOIP.x63ZtARW1O4jLCZT3KHEXwHaEK%26pid%3DApi&f=1");
//        gameDao.createGame(apex);
//        System.out.println(apex);
        User newUser = new User(0, "test4", "test4", "test4", "test4", "test4");
        userDao.createUser(newUser);
}
}
