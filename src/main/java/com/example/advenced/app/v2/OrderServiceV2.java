package com.example.advenced.app.v2;

import com.example.advenced.trace.TraceId;
import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.hellotrace.HelloTraceV1;
import com.example.advenced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;
    public void orderItem(TraceId traceId, String itemId){

        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderService.orderItem()");
            orderRepository.save(status.getTraceId(), itemId);
            trace.end(status);

        }catch (Exception e){
            trace.exception(status, e);
            throw e; //예외를 꼭 던져줘야함;;
        }

    }
}
