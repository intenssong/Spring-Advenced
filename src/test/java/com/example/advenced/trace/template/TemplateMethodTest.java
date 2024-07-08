package com.example.advenced.trace.template;

import com.example.advenced.trace.template.code.AbstractTemplate;
import com.example.advenced.trace.template.code.SubClassLogic1;
import com.example.advenced.trace.template.code.SubClassLogic2;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.MultipartStream;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    @Test
    void templateMethod() {
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
    public void templateMethod1() {
        AbstractTemplate abstractTemplate1 = new SubClassLogic1();
        abstractTemplate1.execute();
        AbstractTemplate abstractTemplate2 = new SubClassLogic2();
        abstractTemplate2.execute();

    }
    @Test
    public void templateMethod2() {
        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("logic1 start");
            }
        };
        abstractTemplate1.execute();

    }

}
