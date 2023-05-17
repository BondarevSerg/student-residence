package ru.bondarev.student.residence.rabbitMQ;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import ru.bondarev.student.residence.dto.request.UserRequest;
import ru.bondarev.student.residence.service.Imp.UserServiceImp;

@Service
@RequiredArgsConstructor

public class RabbitMQConsumerUser {

    private final UserServiceImp userServiceImp;

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void saveUser(UserRequest userRequest){
        userServiceImp.saveUser(userRequest);
    }
}
