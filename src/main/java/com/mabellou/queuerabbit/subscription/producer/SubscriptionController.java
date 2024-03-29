package com.mabellou.queuerabbit.subscription.producer;

import com.mabellou.queuerabbit.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("subscription")
public class SubscriptionController {

    @Autowired
    private SubscriptionMessageGateway messagingGateway;

    @GetMapping
    public String get() {
        messagingGateway.sendMessage(new Student(1L, "test", 16));
        return "hello";
    }
}
