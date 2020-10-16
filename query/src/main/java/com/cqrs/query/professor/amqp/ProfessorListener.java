package com.cqrs.query.professor.amqp;

import com.cqrs.query.aluno.amqp.event.AlunoEvent;
import com.cqrs.query.professor.amqp.events.ProfessorCriadoEvent;
import com.cqrs.query.professor.service.ProfessorCriadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ProfessorListener {

    @Autowired
    private ProfessorCriadoService service;

    @RabbitListener(queues = "professor-queue")
    public void onListener(Message message) {
        try {
            service.onCreated(new ObjectMapper().readValue(message.getBody(), ProfessorCriadoEvent.class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}
