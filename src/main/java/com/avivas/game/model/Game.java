package com.avivas.game.model;

public abstract class Game {

    protected ScoreCalculator scoreCalculator;

    public Game(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public abstract void addScore(int points);

    public abstract String getPrintableScore();

}
