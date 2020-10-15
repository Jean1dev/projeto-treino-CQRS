package com.cqrs.query.aluno.amqp;

import com.cqrs.query.aluno.amqp.event.AlunoEvent;
import com.cqrs.query.aluno.service.AlunoCriadoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AlunoListener {

    @Autowired
    private AlunoCriadoService service;

    @RabbitListener(queues = "aluno-queue")
    public void onListener(Message message) {
        try {
            service.handle(new ObjectMapper().readValue(message.getBody(), AlunoEvent.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
