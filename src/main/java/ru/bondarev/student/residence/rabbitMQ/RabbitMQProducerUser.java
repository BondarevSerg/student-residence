package ru.bondarev.student.residence.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.UserRequest;
@Service
public class RabbitMQProducerUser {


    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.key}")
    private String routingKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQProducerUser(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(UserRequest userRequest){
        rabbitTemplate.convertAndSend(exchange, routingKey, userRequest);
    }
}
