package com.avivas.game.model.bowling;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BowlingGameTest {

    @Test
    public void emptyGame() {
        BowlingGame bowlingGame = new BowlingGame();
        Frame frame = bowlingGame.getCurrentFrame();

        assertTrue(frame.isEmpty());
    }

}
