package com.cqrs.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

    private static final String ALUNO_QUEUE = "aluno-queue";
    private static final String TURMA_QUEUE = "turma-queue";
    private static final String PROFESSOR_QUEUE = "professor-queue";
    private final String exchange = "MATRICULAS_CORE";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue alunoQ() {
        return new Queue(ALUNO_QUEUE, true, false, false);
    }

    @Bean
    public Queue turmaQ() {
        return new Queue(TURMA_QUEUE, true, false, false);
    }

    @Bean
    public Queue professorQ() {
        return new Queue(PROFESSOR_QUEUE, true, false, false);
    }

    @Bean
    public Binding alunos(DirectExchange exchange) {
        return BindingBuilder.bind(alunoQ())
                .to(exchange)
                .with(ALUNO_QUEUE);
    }

    @Bean
    public Binding turmas(DirectExchange exchange) {
        return BindingBuilder.bind(turmaQ())
                .to(exchange)
                .with(TURMA_QUEUE);
    }

    @Bean
    public Binding professor(DirectExchange exchange) {
        return BindingBuilder.bind(professorQ())
                .to(exchange)
                .with(PROFESSOR_QUEUE);
    }
}
