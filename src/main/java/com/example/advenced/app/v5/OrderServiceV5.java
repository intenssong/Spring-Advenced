package com.example.advenced.app.v5;

import com.example.advenced.trace.callback.TraceCallback;
import com.example.advenced.trace.callback.TraceTemplate;
import com.example.advenced.trace.logtrace.LogTrace;
import com.example.advenced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;



@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId){
        template.excute("OrderService.save()",new TraceCallback<Void>() {
            @Override
            public Void call() {
                orderRepository.save(itemId);
                return null;
            };
        });
    }
}
