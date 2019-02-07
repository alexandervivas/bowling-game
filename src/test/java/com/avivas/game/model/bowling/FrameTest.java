package com.avivas.game.model.bowling;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FrameTest {

    @Test
    public void emptyFrame() {
        Frame frame = new Frame();

        assertTrue(frame.isEmpty());
        assertFalse(frame.isFinished());
    }

    @Test
    public void isFinished() {
        Frame frame = new Frame();
        frame.roll(5);
        frame.roll(3);

        assertTrue(frame.isFinished());
    }

    @Test
    public void isNotFinished() {
        Frame frame = new Frame();
        frame.roll(5);

        assertFalse(frame.isFinished());
    }

    @Test
    public void isSpare() {
        Frame frame = new Frame();
        frame.roll(5);

        assertFalse(frame.isFinished());

        frame.roll(5);

        assertTrue(frame.isSpare());
        assertTrue(frame.isFinished());
    }

    @Test
    public void isStrike() {
        Frame frame = new Frame();

        frame.roll(10);

        assertTrue(frame.isStrike());
        assertTrue(frame.isFinished());
    }

}
