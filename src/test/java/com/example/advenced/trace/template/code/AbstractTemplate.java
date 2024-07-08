package com.example.advenced.trace.template.code;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
public abstract class AbstractTemplate {
    public void execute(){
        long startTime = System.currentTimeMillis();

        call();

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }

    protected abstract void call();
}
