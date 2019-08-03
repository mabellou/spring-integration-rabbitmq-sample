package com.mabellou.queuerabbit.queue.producer;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface QueueMessageGateway {

    @Gateway(requestChannel = "amqpOutboundChannel")
    <S> void sendMessage(S request);
}
