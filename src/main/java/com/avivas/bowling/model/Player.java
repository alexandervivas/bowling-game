package com.avivas.bowling.model;

public class Player {

    private String name;
    private Game game;

    public Player(String name) {
        this.name = name;
        game = new Game();
    }

    public Game getGame() {
        return game;
    }

}
