package com.mabellou.queuerabbit.subscription.consumer;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMessageListener {

    @ServiceActivator(inputChannel = "subscriptionReceiverChannel")
    public void receiveFromSubscription(Message<?> message){
        System.out.println("receiveFromSubscription: " + message.toString());
    }

}
