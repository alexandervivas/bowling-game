package com.avivas.game.model;

public interface ScoreCalculator<T, K> {

    K calculate(T data);

}
