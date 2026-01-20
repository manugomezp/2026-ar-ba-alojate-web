package alojate.controller;

import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.service.PublicacionService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8090")
public class ContUsuarios {

    private final PublicacionService servPublicaciones;


    public ContUsuarios(PublicacionService servPublicaciones) {
        this.servPublicaciones = servPublicaciones;
    }

//    @GetMapping("/api/publicaciones")
//    public String publicaciones() {
//        return "Hola desde publicaciones!";
//    }

    @GetMapping("/api/publicaciones")
    public List<OutPublicacionSimple> devolver(){
        List<OutPublicacionSimple> lista = new ArrayList<>();

        OutPublicacionSimple simpleUno = new OutPublicacionSimple("none", "4.9", "USD25", "Una descripción","depto" );
        OutPublicacionSimple simpleDos = new OutPublicacionSimple("none", "3.6", "USD15", "Otra descripcion", "depto" );

        lista.add(simpleUno);
        lista.add(simpleDos);

        System.out.println("SE DEVUELVEN LAS PUBLICACIONES EN FORMATO JSON?");

        return lista;
    }

    @GetMapping("/api/publicaciones-disponibles")
    public List<String> devolverDisponibles(){
        return servPublicaciones.obtenerDisponibles();
    }
}
