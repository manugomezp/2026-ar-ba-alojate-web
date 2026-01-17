package alojate.models.entities.notificacion;

import alojate.models.entities.usuario.Medio;
import alojate.models.entities.usuario.Usuario;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private LocalDateTime fecha;
    private String mensaje;
    private Boolean enviado;
    private Usuario destinatario;
    private Medio medio_de_contacto;
    private String valor;

    public Message(LocalDateTime fecha, String mensaje, Boolean enviado, Usuario destinatario, Medio medio_de_contacto, String valor) {
        this.fecha = fecha;
        this.mensaje = mensaje;
        this.enviado = enviado;
        this.destinatario = destinatario;
        this.medio_de_contacto = medio_de_contacto;
        this.valor = valor;
    }
}
