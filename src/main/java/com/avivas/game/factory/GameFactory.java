package com.avivas.game.factory;

import com.avivas.game.enums.GameEnum;
import com.avivas.game.model.Game;
import com.avivas.game.model.bowling.BowlingGame;

public class GameFactory {

    private static GameFactory instance;

    private GameFactory() { }

    public static GameFactory getInstance() {

        if(instance == null) {

            synchronized (GameFactory.class) {
                if(instance == null) {
                    instance = new GameFactory();
                }
            }

        }

        return instance;

    }

    public Game createGame(GameEnum gameEnum) {
        switch (gameEnum) {
            case BOWLING: return new BowlingGame();
            default: return null;
        }
    }

}
