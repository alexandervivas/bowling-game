package com.avivas.game.model.bowling;

import com.avivas.game.model.ScoreCalculator;

import java.util.Map;

public class BowlingScoreCalculator implements ScoreCalculator<Map<Integer, Frame>, Map<Integer, Frame>> {

    @Override
    public Map<Integer, Frame> calculate(Map<Integer, Frame> data) {
        return calculate(data, 0, 0);
    }

    private Map<Integer, Frame> calculate(Map<Integer, Frame> data, int current, int remainingTrials) {
        Frame currentFrame = data.get(current);

        if(currentFrame.isFinalFrame()) {
            currentFrame.setScore(currentFrame.getFirstBall() + currentFrame.getSecondBall() + currentFrame.getThirdBall());
            return data;
        }

        currentFrame.setScore(currentFrame.getFirstBall() + currentFrame.getSecondBall());

        return calculate(data, current + 1, 0);
    }

}
