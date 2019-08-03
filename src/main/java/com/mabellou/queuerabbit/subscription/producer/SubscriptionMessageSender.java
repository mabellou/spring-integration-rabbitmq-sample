package com.mabellou.queuerabbit.subscription.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.outbound.AmqpOutboundEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionMessageSender {

    @Bean
    @ServiceActivator(inputChannel = "subscriptionOutboundChannel")
    public AmqpOutboundEndpoint amqpOutboundSubscription(AmqpTemplate amqpTemplate) {
        AmqpOutboundEndpoint outbound = new AmqpOutboundEndpoint(amqpTemplate);
        outbound.setExchangeName("exchange_test");
        outbound.setRoutingKey("haha.hehe"); // default exchange - route to queue 'foo'
        return outbound;
    }
}
