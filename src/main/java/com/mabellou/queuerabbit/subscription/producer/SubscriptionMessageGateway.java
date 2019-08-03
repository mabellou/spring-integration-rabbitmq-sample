package com.mabellou.queuerabbit.subscription.producer;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface SubscriptionMessageGateway {

    @Gateway(requestChannel = "subscriptionOutboundChannel")
    <S> void sendMessage(S request);
}
