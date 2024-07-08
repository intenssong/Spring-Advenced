package com.example.advenced.app.v4;

import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.logtrace.LogTrace;
import com.example.advenced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {
    private final LogTrace trace;
    public void save(String itemId){

        AbstractTemplate<Void> template = new AbstractTemplate(trace) {
            @Override
            protected String call() {
                if(itemId.equals("ex")) {
                    throw new IllegalArgumentException("예외발생!!");
                }
                sleep(1000);;
                return "null";
            }
        };
        template.excute("OrderRepository.save()");

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
