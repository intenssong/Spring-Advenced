package com.example.advenced.trace.strategy;

import com.example.advenced.trace.strategy.code.ContextV2;
import com.example.advenced.trace.strategy.code.Strategy;
import com.example.advenced.trace.strategy.code.StrategyImpl1;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@Slf4j
public class ContextV2Test {

    @Test
    void strategy() {
        ContextV2 c = new ContextV2();
        c.excute(new StrategyImpl1());
    }


    @Test
    void strategy2() {
        ContextV2 c = new ContextV2();
        c.excute(()->log.info("logic2 start"));
    }
    @Test
    void strategy3() {
        ContextV2 c = new ContextV2();
        c.excute(new Strategy() {
            @Override
            public void call() {
                log.info("logic3 start");

            }
        });
    }
}
