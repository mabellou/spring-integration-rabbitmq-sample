package com.mabellou.queuerabbit.subscription.consumer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.messaging.MessageChannel;

@Configuration
@EnableIntegration
public class SubscriptionIntegrationConfig {

    @Bean
    Queue queueSubscription() {
        return new Queue("hellooo", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange_test");
    }

    @Bean
    Binding binding(@Qualifier("queueSubscription") Queue queueSubscription, TopicExchange exchange) {
        return BindingBuilder.bind(queueSubscription).to(exchange).with("haha.hehe");
    }

    @Bean
    public SimpleMessageListenerContainer containerSubscription(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container =
                new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames("hellooo");
        return container;
    }

    @Bean
    public PublishSubscribeChannel subscriptionReceiverChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public AmqpInboundChannelAdapter inboundSubscription(@Qualifier("containerSubscription") SimpleMessageListenerContainer listenerContainer,
                                             @Qualifier("subscriptionReceiverChannel") MessageChannel channel) {
        AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(listenerContainer);
        adapter.setOutputChannel(channel);
        return adapter;
    }
}
