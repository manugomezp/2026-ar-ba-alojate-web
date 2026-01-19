package alojate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8090")
public class ContUsuarios {



    @GetMapping("/api/publicaciones")
    public String publicaciones() {
        return "Hola desde publicaciones!";
    }
}
