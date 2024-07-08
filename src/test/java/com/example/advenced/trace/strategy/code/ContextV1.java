package com.example.advenced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV1 {
    private Strategy strategy;
    public ContextV1(Strategy strategy) {
        this.strategy = strategy;
    }
    public void excute() {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }
}
