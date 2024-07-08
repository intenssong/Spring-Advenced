package com.example.advenced.trace.logtrace;

import com.example.advenced.trace.TraceStatus;

public interface LogTrace {
    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus status, Exception exception);
}
