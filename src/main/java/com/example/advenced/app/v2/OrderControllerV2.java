package com.example.advenced.app.v2;

import com.example.advenced.trace.TraceId;
import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.hellotrace.HelloTraceV1;
import com.example.advenced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;
    @GetMapping("/v2/request")
    public String request(TraceId traceId,String itemId){
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderController.request()");
            orderService.orderItem(status.getTraceId(), itemId);
            trace.end(status);

            return "ok";
        }catch (Exception e){
            trace.exception(status, e);
            throw e; //예외를 꼭 던져줘야함;;
        }

    }
}
