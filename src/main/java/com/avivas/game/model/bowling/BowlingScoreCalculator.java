package com.avivas.game.model.bowling;

import com.avivas.game.model.ScoreCalculator;

import java.util.Map;

public class BowlingScoreCalculator implements ScoreCalculator<Map<Integer, Frame>, Map<Integer, Frame>> {

    @Override
    public Map<Integer, Frame> calculate(Map<Integer, Frame> data) {
        Map<Integer, Frame> calculated = calculate(data, 0);
        int score = 0;

        for(int i = 0; i < calculated.size(); i++) {
            score += calculated.get(i).getScore();
            calculated.get(i).setScore(score);
        }

        return calculated;
    }

    private Map<Integer, Frame> calculate(Map<Integer, Frame> data, int current) {
        Frame currentFrame = data.get(current);
        int score = currentFrame.getFirstBall() + currentFrame.getSecondBall();

        if(currentFrame.isFinalFrame()) {
            currentFrame.setScore(score + currentFrame.getThirdBall());
            return data;
        }

        if(currentFrame.isStrike()) {
            Frame firstNext = data.get(current + 1);
            score += firstNext.getFirstBall();

            if(firstNext.isFinalFrame() || !firstNext.isStrike()) {
                score += firstNext.getSecondBall();
            } else {
                Frame secondNext = data.get(current + 2);
                score += secondNext.getFirstBall();
            }
        }

        if(currentFrame.isSpare()) {
            Frame firstNext = data.get(current + 1);
            score += firstNext.getFirstBall();
        }

        currentFrame.setScore(score);

        return calculate(data, current + 1);
    }

}
