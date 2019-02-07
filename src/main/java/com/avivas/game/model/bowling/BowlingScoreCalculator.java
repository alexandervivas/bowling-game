package com.avivas.game.model.bowling;

import com.avivas.game.model.ScoreCalculator;

import java.util.HashMap;
import java.util.Map;

public class BowlingScoreCalculator implements ScoreCalculator<Map<Integer, Frame>, Map<Integer, Frame>> {

    @Override
    public Map<Integer, Frame> calculate(Map<Integer, Frame> data) {
        return new HashMap<>();
    }

}
