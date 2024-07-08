package com.example.advenced.trace.callback;

import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.logtrace.LogTrace;
import org.springframework.boot.autoconfigure.web.WebProperties;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T excute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            T result =callback.call();
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e; //예외를 꼭 던져줘야함;;
        }
    }
}
