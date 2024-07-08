package com.example.advenced.app.v4;

import com.example.advenced.trace.TraceStatus;
import com.example.advenced.trace.logtrace.LogTrace;
import com.example.advenced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class OrderServiceV4 {
    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;
    public void orderItem( String itemId){
        AbstractTemplate<Void> template = new AbstractTemplate(trace) {
            @Override
            protected String call() {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.excute("OrderService.orderItem()");


    }
}
