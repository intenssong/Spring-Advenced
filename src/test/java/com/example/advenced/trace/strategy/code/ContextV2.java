package com.example.advenced.trace.strategy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContextV2 {
    public void excute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        strategy.call();

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }
}
