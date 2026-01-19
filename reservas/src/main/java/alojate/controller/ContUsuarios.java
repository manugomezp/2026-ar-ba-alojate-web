package alojate.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:9000")
public class ContUsuarios{


    @GetMapping("/api/reservas")
    public String reservas() {
        return "Hola desde reservas!";
    }


}
