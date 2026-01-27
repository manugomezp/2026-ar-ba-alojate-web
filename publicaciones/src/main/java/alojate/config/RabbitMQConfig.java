package alojate.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String QUEUE_PUBLICACIONES = "publicaciones.queue";
    public static final String EXCHANGE_RESERVAS = "reservas.exchange";

    @Bean
    public Queue publicacionesQueue() {
        return QueueBuilder.durable(QUEUE_PUBLICACIONES).build();
    }

    @Bean
    public TopicExchange reservasExchange() {
        return new TopicExchange(EXCHANGE_RESERVAS, true, false);
    }

    @Bean
    public Binding bindingReservaCreada(
            Queue reservasCreadaQueue,
            TopicExchange reservasExchange) {

        return BindingBuilder
                .bind(reservasCreadaQueue)
                .to(reservasExchange)
                .with("reserva.creada");
    }

    // 👇 Conversor JSON para deserializar mensajes
    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // 👇 Listener Container Factory que usa el conversor
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            Jackson2JsonMessageConverter converter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(converter);
        return factory;
    }


}
