package com.avivas.game.model.bowling;

import com.avivas.game.model.Game;

import java.util.HashMap;
import java.util.Map;

public class BowlingGame extends Game {

    private Map<Integer, Frame> frames;

    public BowlingGame() {
        super(new BowlingScoreCalculator());
        frames = new HashMap<Integer, Frame>();
    }

    @Override
    public void addScore(int points) {
        getCurrentFrame().roll(points);
    }

    @Override
    public int getScore() {
        return scoreCalculator.calculate(frames);
    }

    public Frame getCurrentFrame() {
        if(frames.isEmpty()) {
            return createFrame();
        }

        Frame frame = frames.get(frames.size() - 1);

        if(frame.isFinished()) {
            return createFrame();
        }

        return frame;
    }

    private Frame createFrame() {
        Frame frame = new Frame();
        frames.put(frames.size(), frame);
        return frame;
    }
}
