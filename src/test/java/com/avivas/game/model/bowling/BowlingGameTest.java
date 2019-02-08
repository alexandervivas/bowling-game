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

    @Test
    public void getPrintableScoreAllZero() {
        BowlingGame bowlingGame = new BowlingGame("Test");

        while(!bowlingGame.getCurrentFrame().isFinalFrame() && !bowlingGame.getCurrentFrame().isFinished()) {
            bowlingGame.addScore(0);
        }

        assertEquals(bowlingGame.getPrintableScore(), "Test\n" +
                "Pinfalls\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\t0\n" +
                "Score\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0\t\t0");
    }

    @Test
    public void getPrintableScoreAllStrike() {
        BowlingGame bowlingGame = new BowlingGame("Test");

        while(!bowlingGame.getCurrentFrame().isFinalFrame() && !bowlingGame.getCurrentFrame().isFinished()) {
            bowlingGame.addScore(10);
        }

        assertEquals(bowlingGame.getPrintableScore(), "Test\n" +
                "Pinfalls\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t\tX\t0\t0\t0\n" +
                "Score\t\t30\t\t60\t\t90\t\t120\t\t150\t\t180\t\t210\t\t230\t\t240\t\t240");
    }

    @Test
    public void getPrintableScoreSampleTest() {
        BowlingGame bowlingGame = new BowlingGame("Jeff");

        bowlingGame.addScore(10);
        bowlingGame.addScore(7);
        bowlingGame.addScore(3);
        bowlingGame.addScore(9);
        bowlingGame.addScore(0);
        bowlingGame.addScore(10);
        bowlingGame.addScore(0);
        bowlingGame.addScore(8);
        bowlingGame.addScore(8);
        bowlingGame.addScore(2);
        bowlingGame.addScore(0);
        bowlingGame.addScore(6);
        bowlingGame.addScore(10);
        bowlingGame.addScore(10);
        bowlingGame.addScore(10);
        bowlingGame.addScore(8);
        bowlingGame.addScore(1);

        assertEquals(bowlingGame.getPrintableScore(), "Jeff\n" +
                "Pinfalls\t\tX\t7\t/\t9\t0\t\tX\t0\t8\t8\t/\t0\t6\t\tX\t\tX\tX\t8\t1\n" +
                "Score\t\t20\t\t39\t\t48\t\t66\t\t74\t\t84\t\t90\t\t120\t\t148\t\t167");
    }

}
