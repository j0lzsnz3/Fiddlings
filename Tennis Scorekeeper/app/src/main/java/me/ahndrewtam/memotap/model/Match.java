package me.ahndrewtam.memotap.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Match extends RealmObject {
    @PrimaryKey
    private long id;
    private int sets;
    private String duration;
    private String date;
    private String playerOne;
    private int playerOneGameScore;
    private RealmList<RealmInteger> playerOneScores;
    private String playerTwo;
    private int playerTwoGameScore;
    private RealmList<RealmInteger> playerTwoScores;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public int getPlayerOneGameScore() {
        return playerOneGameScore;
    }

    public void setPlayerOneGameScore(int playerOneGameScore) {
        this.playerOneGameScore = playerOneGameScore;
    }

    public RealmList<RealmInteger> getPlayerOneScores() {
        return playerOneScores;
    }

    public void setPlayerOneScores(RealmList<RealmInteger> playerOneScores) {
        this.playerOneScores = playerOneScores;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public int getPlayerTwoGameScore() {
        return playerTwoGameScore;
    }

    public void setPlayerTwoGameScore(int playerTwoGameScore) {
        this.playerTwoGameScore = playerTwoGameScore;
    }

    public RealmList<RealmInteger> getPlayerTwoScores() {
        return playerTwoScores;
    }

    public void setPlayerTwoScores(RealmList<RealmInteger> playerTwoScores) {
        this.playerTwoScores = playerTwoScores;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
}
