package com.example.advenced.trace.hellotrace;

import com.example.advenced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV2Test {

    @Autowired
    private HelloTraceV2 helloTraceV2;

    @Test
    void begin_end(){
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus traceStatus1 = trace.begin("Hello1");
        TraceStatus traceStatus2 = trace.beginSync(traceStatus1.getTraceId(), "hello2");

        trace.end(traceStatus2);
        trace.end(traceStatus1);
    }
}