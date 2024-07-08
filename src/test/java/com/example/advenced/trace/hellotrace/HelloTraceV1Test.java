package com.example.advenced.trace.hellotrace;

import com.example.advenced.trace.TraceStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloTraceV1Test {

    @Autowired
    private HelloTraceV1 helloTraceV1;

    @Test
    void begin_end(){
        HelloTraceV1 trace = new HelloTraceV1();
        TraceStatus traceStatus = trace.begin("Hello World");
        trace.end(traceStatus);
        trace.exception(traceStatus, new IllegalAccessException());
    }
}