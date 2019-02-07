package com.avivas.game.model.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingGameTest {

    @Test
    public void returnEmptyFrameForEmptyGame() {
        BowlingGame bowlingGame = new BowlingGame(java.util.UUID.randomUUID().toString());
        Frame frame = bowlingGame.getCurrentFrame();

        assertTrue(frame.isEmpty());
    }

    @Test
    public void returnFrameWithOneBall() {
        BowlingGame bowlingGame = new BowlingGame(java.util.UUID.randomUUID().toString());
        bowlingGame.addScore(5);
        Frame frame = bowlingGame.getCurrentFrame();

        assertFalse(frame.isEmpty());
    }

    @Test
    public void createNewFrameAfterAFinishedOne() {
        BowlingGame bowlingGame = new BowlingGame(java.util.UUID.randomUUID().toString());

        bowlingGame.addScore(5);
        bowlingGame.addScore(5);

        Frame frame = bowlingGame.getCurrentFrame();

        assertTrue(frame.isEmpty());
    }

}
