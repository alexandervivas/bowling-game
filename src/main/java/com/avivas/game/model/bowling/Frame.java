package com.avivas.game.model.bowling;

public class Frame {

    private int firstBall;
    private int secondBall;
    private int thirdBall;
    private boolean first;
    private boolean second;
    private boolean third;
    private boolean isFinalFrame;
    private int score = 0;

    public Frame(boolean isFinalFrame) {
        firstBall = 0;
        secondBall = 0;
        first = false;
        second = false;
        this.isFinalFrame = isFinalFrame;
    }

    public void roll(int pins) {
        if(isFinished()) {
            return;
        }

        if(first) {
            if(isFinalFrame) {
                if(second) {
                    thirdBall = pins;
                    third = true;
                } else {
                    secondBall = pins;
                    second = true;
                }
            } else {
                secondBall = pins;
                second = true;
            }

        } else {
            firstBall = pins;
            first = true;
        }
    }

    public int getFirstBall() {
        return firstBall;
    }

    public int getSecondBall() {
        return secondBall;
    }

    public int getThirdBall() {
        return thirdBall;
    }

    public boolean isStrike() {
        return firstBall == 10;
    }

    public boolean isSpare() {
        return !isStrike() && (firstBall + secondBall) == 10;
    }

    public boolean isFinished() {
        if(isFinalFrame) {
            return first && second && third;
        }
        return isStrike() || first && second;
    }

    public boolean isEmpty() {
        return !first && !second;
    }

    public boolean isFinalFrame() {
        return isFinalFrame;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
