package alojate.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ContUsuarios{

    private final ServRecorrido servRecorrido;

    public ContUsuarios(ServRecorrido servRecorrido) {
        this.servRecorrido = servRecorrido;
    }


    @PostMapping("/api/recorridos")
    public void generarRecorrido(@RequestBody String empresa_id){
        servRecorrido.generarRecorrido(empresa_id);
    }

}
