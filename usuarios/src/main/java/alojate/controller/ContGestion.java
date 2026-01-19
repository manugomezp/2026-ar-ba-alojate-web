package alojate.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:9020")

public class ContGestion {

    @GetMapping("/api/usuarios")
    public String usuarios() {
        return "Hola desde usuarios!";
    }

}
