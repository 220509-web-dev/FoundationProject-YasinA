package dev.GGCritics.Entities;

public class Game {
    private int gameId;
    private String title;
    private String description;
    private int averageScore;
    private String image;

    public Game() {}

    public Game(int gameId, String title, String description, int averageScore, String image) {
        this.gameId = gameId;
        this.title = title;
        this.description = description;
        this.averageScore = averageScore;
        this.image = image;
    }


    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
