package alojate.service;

import alojate.models.entities.publicacion.Categoria;
import alojate.models.entities.publicacion.Divisa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeederService implements CommandLineRunner {

    @Autowired
    private PublicacionService publicacionService;

    public void init(){
        // CATEGORIA
        Categoria casa = new Categoria(0L, "Casa");
        Categoria depto = new Categoria(1L,"Depto");
        Categoria hotel = new Categoria(2L,"Hotel");
        Categoria loft = new Categoria(3L,"Loft");

        publicacionService.categorias.addAll(List.of(casa, depto, hotel, loft));

        // DIVISA

        Divisa euro =  new Divisa(0L,"€", "Moneda europea.");
        Divisa usdolar =   new Divisa(1L, "USD", "Dolar de USA.");
        Divisa pesos = new Divisa(2L, "$", "Argentina.");

        publicacionService.divisas.addAll(List.of(euro, pesos, usdolar));

    }



    @Override
    public void run(String... args) throws Exception {
        this.init();
    }

}
