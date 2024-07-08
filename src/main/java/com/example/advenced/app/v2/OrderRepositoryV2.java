package com.example.advenced.app.v2;

import com.example.advenced.trace.TraceId;
import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.hellotrace.HelloTraceV1;
import com.example.advenced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {
    private final HelloTraceV2 trace;
    public void save(TraceId traceId, String itemId){
        //저장 로직
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderRepository.save()");

            if(itemId.equals("ex")) {

                throw new IllegalArgumentException("예외발생!!");

            }

            sleep(1000);

            trace.end(status);
        }catch (Exception e){
            trace.exception(status, e);
            throw e; //예외를 꼭 던져줘야함;;
        }


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
