package com.cqrs.query.turma.amqp;

import com.cqrs.query.turma.amqp.events.TurmaCriadaEvent;
import com.cqrs.query.turma.service.TurmaCriadaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TurmaListener {

    @Autowired
    private TurmaCriadaService service;

    @RabbitListener(queues = "turma-queue")
    public void onListener(Message message) {
        try {
            service.onCreated(new ObjectMapper().readValue(message.getBody(), TurmaCriadaEvent.class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
