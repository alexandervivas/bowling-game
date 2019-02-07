package com.avivas.game.model;

public abstract class Game {

    protected ScoreCalculator scoreCalculator;
    protected String player;

    public Game(ScoreCalculator scoreCalculator, String player) {
        this.scoreCalculator = scoreCalculator;
        this.player = player;
    }

    public abstract void addScore(int points);

    public abstract String getPrintableScore();

}
