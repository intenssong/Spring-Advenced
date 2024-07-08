package com.example.advenced.trace.template;

import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;

public abstract class AbstractTemplate<T> {
    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T excute(String message){
        TraceStatus status = null;

        try {
            status = trace.begin(message);

            T result = call();
            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call();


}
