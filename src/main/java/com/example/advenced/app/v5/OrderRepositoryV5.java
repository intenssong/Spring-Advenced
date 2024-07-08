package com.example.advenced.app.v5;

import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.callback.TraceCallback;
import com.example.advenced.trace.callback.TraceTemplate;
import com.example.advenced.trace.logtrace.LogTrace;
import com.example.advenced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate traceTemplate;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.traceTemplate = new TraceTemplate(logTrace);
    }

    public void save(String itemId){
        traceTemplate.excute("OrderRepository.save()", new TraceCallback<Void>() {
            @Override
            public Void call() {
                if(itemId.equals("ex")) {
                    throw new IllegalArgumentException("예외발생!!");
                }
                sleep(1000);;
                return null;
            }
        });


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
