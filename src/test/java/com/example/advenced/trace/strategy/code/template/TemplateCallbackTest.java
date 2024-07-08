package com.example.advenced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    public void test() {
        TimeTemplate timeTemplate = new TimeTemplate();
        timeTemplate.excute(()->log.info("callback 2 start") );
    }
}
