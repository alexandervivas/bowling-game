package com.avivas.game.model.bowling;

import com.avivas.game.model.Game;
import com.avivas.game.model.ScoreCalculator;

import java.util.HashMap;
import java.util.Map;

public class BowlingGame extends Game {

    private Map<Integer, Frame> frames;
    private static final int MAX_FRAMES = 10;

    public BowlingGame(String player) {
        super(new BowlingScoreCalculator(), player);
        frames = new HashMap<Integer, Frame>();
    }

    @Override
    public void addScore(int points) {
        getCurrentFrame().roll(points);
    }

    @Override
    public String getPrintableScore() {
        StringBuilder printableScore = new StringBuilder(player).append("\nPinfalls");

        Map<Integer, Frame> data = (Map<Integer, Frame>) scoreCalculator.calculate(frames);

        data.entrySet().stream().filter(entry -> !entry.getValue().isFinalFrame()).forEach(entry -> {
            Frame frame = entry.getValue();

            printableScore.append("\t");

            if(frame.isStrike()) {
                printableScore.append("\tX");
            } else if(frame.isSpare()) {
                printableScore.append(frame.getFirstBall()).append("\t/");
            } else {
                printableScore.append(frame.getFirstBall()).append("\t").append(frame.getSecondBall());
            }

        });

        data.entrySet().stream().filter(entry -> entry.getValue().isFinalFrame()).forEach(entry -> {
            Frame frame = entry.getValue();
            printableScore.append("\t").append(frame.getFirstBall() == 10 ? "X" : frame.getFirstBall());
            printableScore.append("\t").append(frame.getSecondBall() == 10 ? "X" : frame.getSecondBall());
            printableScore.append("\t").append(frame.getThirdBall() == 10 ? "X" : frame.getThirdBall());
        });

        printableScore.append("\nScore");

        data.entrySet().stream().filter(entry -> !entry.getValue().isFinalFrame()).forEach(entry -> {
            printableScore.append("\t\t").append(entry.getValue().getScore());
        });

        return printableScore.toString();
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
        Frame frame = new Frame(frames.size() == MAX_FRAMES - 1);
        frames.put(frames.size(), frame);
        return frame;
    }
}
