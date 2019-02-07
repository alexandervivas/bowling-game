package com.avivas.game.model.bowling;

public class Frame {

    private int firstBall;
    private int secondBall;
    private boolean first;
    private boolean second;

    public Frame() {
        firstBall = 0;
        secondBall = 0;
        first = false;
        second = false;
    }

    public void roll(int pins) {
        if(first && second) {
            return;
        }

        if(first) {
            secondBall = pins;
            second = true;
        } else {
            firstBall = pins;
            first = true;
        }
    }

    public boolean isStrike() {
        return firstBall == 10;
    }

    public boolean isSpare() {
        return !isStrike() && (firstBall + secondBall) == 10;
    }

    public boolean isFinished() {
        return first && second;
    }

}
