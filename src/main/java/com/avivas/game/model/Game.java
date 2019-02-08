package com.avivas.game.model;

public abstract class Game {

    // a game delegates the scoring process to a specialized entity
    protected ScoreCalculator scoreCalculator;

    // name of the player
    protected String player;

    public Game(ScoreCalculator scoreCalculator, String player) {
        this.scoreCalculator = scoreCalculator;
        this.player = player;
    }

    public abstract void addScore(int points);

    public abstract String getPrintableScore();

}
