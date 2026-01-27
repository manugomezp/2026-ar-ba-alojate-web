package alojate.service;

import alojate.config.RabbitMQConfig;
import alojate.events.ReservaEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservaEventPublisher {

    private final RabbitTemplate rabbitTemplate;

    public ReservaEventPublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

//    public void publicarReservaCreada(ReservaEvent event) {
//        System.out.println("ENVIAR RESERVA CREADA");
//        rabbitTemplate.convertAndSend(
//                RabbitMQConfig.EXCHANGE_RESERVAS,
//                RabbitMQConfig.ROUTING_KEY_RESERVA_CREADA,
//                event
//        );}
    public void publicarReservaCreada(ReservaEvent event) {
        System.out.println("ENVIAR RESERVA CREADA");

        try {
            rabbitTemplate.convertAndSend(
                    RabbitMQConfig.EXCHANGE_RESERVAS,
                    RabbitMQConfig.ROUTING_KEY_RESERVA_CREADA,
                    event
            );
            System.out.println("MENSAJE ENVIADO OK");
        } catch (Exception e) {
            System.err.println("ERROR AL ENVIAR MENSAJE");
            e.printStackTrace();}
    }


}

