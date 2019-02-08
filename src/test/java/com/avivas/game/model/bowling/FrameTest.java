package com.avivas.game.model.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class FrameTest {

    @Test
    public void emptyFrame() {
        Frame frame = new Frame(false);

        assertTrue(frame.isEmpty());
        assertFalse(frame.isFinished());
    }

    @Test
    public void isFinished() {
        Frame frame = new Frame(false);
        frame.roll(5);
        frame.roll(3);

        assertTrue(frame.isFinished());
    }

    @Test
    public void isNotFinished() {
        Frame frame = new Frame(false);
        frame.roll(5);

        assertFalse(frame.isFinished());
    }

    @Test
    public void isSpare() {
        Frame frame = new Frame(false);
        frame.roll(5);

        assertFalse(frame.isFinished());

        frame.roll(5);

        assertTrue(frame.isSpare());
        assertTrue(frame.isFinished());
    }

    @Test
    public void isStrike() {
        Frame frame = new Frame(false);

        frame.roll(10);

        assertTrue(frame.isStrike());
        assertTrue(frame.isFinished());
    }

    @Test
    public void ifFinishedDoNotModify() {
        Frame frame = new Frame(false);

        frame.roll(10);
        frame.roll(5);

        assertTrue(frame.isFinished());
        assertEquals(frame.getFirstBall(), 10);
        assertEquals(frame.getSecondBall(), 0);
    }

}
