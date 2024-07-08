package com.example.advenced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeTemplate {

    public void excute(Callback callback) {
        long startTime = System.currentTimeMillis();

        callback.call();

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }
}
