package com.example.advenced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyImpl1 implements Strategy {

    @Override
    public void call() {
        log.info("StrategyImpl1");
    }
}