package dev.GGCritics.Daos;

import dev.GGCritics.Model.Game;
import dev.GGCritics.Utilities.ConnectionFactoryUtility;

import java.sql.Connection;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GameDaoPostgres implements GameDao{

    @Override
    public Game createGame(Game game) {

        try(Connection conn = ConnectionFactoryUtility.getConnection()) {
            String sql = "insert into ent_ggcritics.game values (default,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getTitle());
            ps.setString(2, game.getDescription());
            ps.setInt(3, game.getAverageScore());
            ps.setString(4, game.getImage());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("id");

            game.setGameId(generatedId);
            return game;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Game getGameById(int id) {

        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "select * from ent_ggcritics.game where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();

            Game game = new Game();
            game.setGameId(id);
            game.setTitle(rs.getString("title"));
            game.setDescription(rs.getString("description"));
            game.setAverageScore(rs.getInt("average_score"));
            game.setImage(rs.getString("image"));
            return game;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Game> getAllGames() {

        try(Connection conn = ConnectionFactoryUtility.getConnection()){
            String sql = "select * from ent_ggcritics.game";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

        List<Game> games = new ArrayList<>();

        while(rs.next()){
            Game game = new Game();
            game.setGameId(rs.getInt("id"));
            game.setTitle(rs.getString("title"));
            game.setDescription(rs.getString("description"));
            game.setAverageScore(rs.getInt("average_score"));
            game.setImage(rs.getString("image"));
            games.add(game);
            }
            return games;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Game updateGame(Game game) {

        try (Connection conn = ConnectionFactoryUtility.getConnection()) {
            String sql = "update ent_ggcritics.game set title = ?, description = ?, average_score = ?, image = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, game.getTitle());
            ps.setString(2, game.getDescription());
            ps.setInt(3, game.getAverageScore());
            ps.setString(4, game.getImage());

            ps.execute();

            return game;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

        @Override
    public void deleteGameById(int id) {

            try(Connection conn = ConnectionFactoryUtility.getConnection()){
                String sql = "delete from ent_ggcritics.game where id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1,id);
                ps.execute();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
    }
}
