package com.example.advenced.trace.strategy;

import com.example.advenced.trace.strategy.code.ContextV1;
import com.example.advenced.trace.strategy.code.Strategy;
import com.example.advenced.trace.strategy.code.StrategyImpl1;
import com.example.advenced.trace.strategy.code.StrategyImpl2;
import com.example.advenced.trace.template.code.AbstractTemplate;
import com.example.advenced.trace.template.code.SubClassLogic1;
import com.example.advenced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    void strategy() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        log.info("logic1 start");

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        log.info("logic2 start");

        long endTime = System.currentTimeMillis();
        long result = endTime - startTime;
        log.info("result:{}", result);
    }

    @Test
    public void context1() {
        ContextV1 contextV1 = new ContextV1(new StrategyImpl1());
        contextV1.excute();
        ContextV1 contextV2 = new ContextV1(new StrategyImpl2());
        contextV2.excute();

    }
    @Test
    public void context2() {
        Strategy st1 = new Strategy(){

            @Override
            public void call() {
                log.info("logic1 start");
            }
        };
        ContextV1 contextV1 = new ContextV1(st1);
        contextV1.excute();

    }

    @Test
    public void context3() {
        ContextV1 contextV1 = new ContextV1(new Strategy(){
            @Override
            public void call() {
                log.info("logic1 start");
            }
        });
        contextV1.excute();

    }


    @Test
    public void context4() {
        ContextV1 contextV1 = new ContextV1(() -> log.info("logic1 start"));
        contextV1.excute();

    }
}
