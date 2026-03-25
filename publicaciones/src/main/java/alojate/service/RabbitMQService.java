package alojate.service;

import alojate.config.RabbitMQConfig;
import alojate.events.ReservaEvent;
import alojate.models.entities.publicacion.Publicacion;
import alojate.models.entities.publicacion.Reserva;
import alojate.models.repository.IReposPublicacion;
import alojate.models.repository.IReposReserva;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService {

    private final IReposPublicacion reposPublicacion;
    private final IReposReserva  reposReserva;

    public RabbitMQService(IReposPublicacion reposPublicacion, IReposReserva reposReserva) {
        this.reposPublicacion = reposPublicacion;
        this.reposReserva = reposReserva;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PUBLICACIONES)
    public void onReservaCreada(ReservaEvent event) {
        System.out.println("Reserva recibida: " + event);
        try {
            Publicacion publicacion = reposPublicacion
                    .findById(Long.parseLong(event.getPublicacion_id()))
                    .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));

            System.out.println("ESTOY CONSUMIENDO LA COLA DE RESERVAS");

            reposReserva.save(new Reserva(publicacion, event.getDesde(), event.getHasta()));

        }
        catch(Exception e) {
            System.out.println("No se pudo obtener el mensaje de la cola.");
        }

    }
}
