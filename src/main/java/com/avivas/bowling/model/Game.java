package com.avivas.bowling.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<Frame> frames = new ArrayList<Frame>();

    public Game() { }

    public int getScore() {
        return 0;
    }

    public void addScore(int score) {

        getCurrentFrame().roll(score);

    }

    private Frame getCurrentFrame() {
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
        frames.add(frame);
        return frame;
    }
}
