package com.avivas.game.model.bowling;

import com.avivas.game.model.Game;
import com.avivas.game.model.ScoreCalculator;

import java.util.HashMap;
import java.util.Map;

public class BowlingGame extends Game {

    private Map<Integer, Frame> frames;
    private static final int MAX_FRAMES = 10;

    public BowlingGame() {
        super(new BowlingScoreCalculator());
        frames = new HashMap<Integer, Frame>();
    }

    @Override
    public void addScore(int points) {
        getCurrentFrame().roll(points);
    }

    @Override
    public String getPrintableScore() {
        StringBuilder firstLine = new StringBuilder("Frame");
        frames.entrySet().stream().forEach(entry -> firstLine.append("\t").append(entry.getKey() + 1));

        return firstLine.toString();
    }

    public Frame getCurrentFrame() {
        if(frames.isEmpty()) {
            return createFrame();
        }

        Frame frame = frames.get(frames.size() - 1);

        if(frame.isFinished() && frames.size() < MAX_FRAMES) {
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
