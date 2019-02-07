package com.avivas.game.factory;

import com.avivas.game.enums.GameEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameFactoryTest {

    @Test
    public void sameInstanceTest() {

        assertEquals(GameFactory.getInstance(), GameFactory.getInstance());

    }

    @Test
    public void createValidGame() {

        assertNotNull(GameFactory.getInstance().createGame(GameEnum.BOWLING, java.util.UUID.randomUUID().toString()));

    }

    @Test
    public void createInvalidGame() {

        assertNull(GameFactory.getInstance().createGame(GameEnum.OTHER, java.util.UUID.randomUUID().toString()));

    }
}
