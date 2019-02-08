package com.avivas.game.model.bowling;

import com.avivas.game.model.ScoreCalculator;

import java.util.Map;

public class BowlingScoreCalculator implements ScoreCalculator<Map<Integer, Frame>, Map<Integer, Frame>> {

    /**
     * Calculates all particular frames scores and then performs an accumulator for every frame
     * @param data
     * @return
     */
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

    /**
     * Calculates the particular score for every frame in the map
     * @param data: the map
     * @param current: the current frame in review
     * @return calculated map
     */
    private Map<Integer, Frame> calculate(Map<Integer, Frame> data, int current) {
        Frame currentFrame = data.get(current);
        int score = currentFrame.getFirstBall() + currentFrame.getSecondBall();

        // only the final frame has a third ball
        if(currentFrame.isFinalFrame()) {
            currentFrame.setScore(score + currentFrame.getThirdBall());

            // this is the final frame so here finishes the scoring process
            return data;
        }

        // if its a strike it has to get the next two balls
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

        // if its a spare it has to get the next ball
        if(currentFrame.isSpare()) {
            Frame firstNext = data.get(current + 1);
            score += firstNext.getFirstBall();
        }

        currentFrame.setScore(score);

        // take the next frame and do it again
        return calculate(data, current + 1);
    }

}
