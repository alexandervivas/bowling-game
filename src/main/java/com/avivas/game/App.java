package com.avivas.game;

import com.avivas.game.enums.GameEnum;
import com.avivas.game.factory.GameFactory;
import com.avivas.game.model.Game;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Game game = GameFactory.getInstance().createGame(GameEnum.BOWLING);
    }
}
