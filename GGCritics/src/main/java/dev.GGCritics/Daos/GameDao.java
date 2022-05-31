package dev.GGCritics.Daos;

import dev.GGCritics.Entities.Game;

import java.util.List;

public interface GameDao {

    Game createGame(Game game);

// Gets game by id
        Game getGameById ( int id);

// Query to get all games and return it as a list
        List<Game> getAllGames ();

// Updates a game
        Game updateGame (Game game);

// Deletes a game by id
        void deleteGameById ( int id);
}
