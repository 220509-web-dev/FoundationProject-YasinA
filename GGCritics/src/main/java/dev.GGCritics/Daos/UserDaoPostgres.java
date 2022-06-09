// Packages
package dev.GGCritics.Daos;

// Imports
import dev.GGCritics.Model.User;
import dev.GGCritics.Utilities.ConnectionFactoryUtility;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoPostgres implements UserDao{

// Query to get all users and return it as a list
    @Override
    public List<User> getAllUsers() {
        try( Connection conn = ConnectionFactoryUtility.getConnection() ) {
            String sql = "select * from ent_ggcritics.app_user";
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            List<User> users = new ArrayList<>();

            while (rs.next()) {
                users.add( new User(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password")));
//                User user = new User();
//                user.setUserId(rs.getInt("id"));
//                user.setFirstName(rs.getString("first_name"));
//                user.setLastName(rs.getString("last_name"));
//                user.setEmail(rs.getString("email"));
//                user.setUsername(rs.getString("username"));
//                user.setPassword(rs.getString("password"));

            }
            return users;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User createUser(User user) {

        try(Connection conn = ConnectionFactoryUtility.getConnection()) {
            String sql = "insert into ent_ggcritics.app_user values (default,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("id");

            user.setUserId(generatedId);
            return user;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {

        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "select * from ent_ggcritics.app_user where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setUserId(id);
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "select * from ent_ggcritics.app_user where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setUserId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }


    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "select * from ent_ggcritics.app_user where username = ? and password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            rs.next();

            User user = new User();
            user.setUserId(rs.getInt("id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setEmail(rs.getString("email"));
            user.setUsername(rs.getString("username"));
//            user.setPassword(rs.getString("password"));
            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {

        try (Connection conn = ConnectionFactoryUtility.getConnection()) {
            String sql = "update ent_ggcritics.app_user set first_name = ?, last_name = ?, email = ?, username = ?, password = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getUsername());
            ps.setString(5, user.getPassword());

            ps.execute();

            return user;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUserById(int id) {
        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "delete from ent_ggcritics.app_user where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}
