package com.cqrs.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfiguration {

    private final String exchange = "MATRICULAS_CORE";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Binding alunos(DirectExchange exchange) {
        String queue2 = "aluno-queue";
        return BindingBuilder.bind(new Queue(queue2, true, false, false))
                .to(exchange)
                .with(queue2);
    }

    @Bean
    public Binding turmas(DirectExchange exchange) {
        String queue2 = "turma-queue";
        return BindingBuilder.bind(new Queue(queue2, true, false, false))
                .to(exchange)
                .with(queue2);
    }

    @Bean
    public Binding professor(DirectExchange exchange) {
        String queue2 = "professor-queue";
        return BindingBuilder.bind(new Queue(queue2, true, false, false))
                .to(exchange)
                .with(queue2);
    }
}
