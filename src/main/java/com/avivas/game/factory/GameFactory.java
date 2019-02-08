package com.avivas.game.factory;

import com.avivas.game.enums.GameEnum;
import com.avivas.game.model.Game;
import com.avivas.game.model.bowling.BowlingGame;

public class GameFactory {

    private static GameFactory instance;

    private GameFactory() { }

    public static GameFactory getInstance() {

        if(instance == null) {

            // double validation and synchronized to make this thread-safe
            synchronized (GameFactory.class) {
                if(instance == null) {
                    instance = new GameFactory();
                }
            }

        }

        return instance;

    }

    /**
     * Creates a game depending on the name of the game
     * @param gameEnum: name of the game
     * @param player: name of player
     * @return a new game for player
     */
    public Game createGameForPlayer(GameEnum gameEnum, String player) {
        // @TODO: change for switch as soon as there is support for more games
        if(gameEnum == GameEnum.BOWLING) {
            return new BowlingGame(player);
        }
        return null;
    }

}
