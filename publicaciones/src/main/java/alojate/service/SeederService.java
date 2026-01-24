package alojate.service;

import alojate.models.entities.publicacion.Categoria;
import alojate.models.entities.publicacion.Divisa;
import alojate.models.entities.publicacion.Publicacion;
import alojate.models.entities.publicacion.Ubicacion;
import alojate.models.repository.IReposCategoria;
import alojate.models.repository.IReposDivisa;
import alojate.models.repository.IReposPublicacion;
import alojate.models.repository.IUbicacionRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SeederService implements CommandLineRunner {

    @Autowired
    private IUbicacionRepos ubicacionRepos;
    @Autowired
    private IReposDivisa iReposDivisa;
    @Autowired
    private IReposCategoria reposCategoria;
    @Autowired
    private IReposPublicacion reposPublicacion;

    public void init(){
        // CATEGORIA
        Categoria casa = new Categoria( "Casa");
        Categoria depto = new Categoria("Depto");
        Categoria hotel = new Categoria("Hotel");
        Categoria loft = new Categoria("Loft");

        reposCategoria.saveAll(List.of(casa, depto, hotel, loft));

        // DIVISA

        Divisa euro =  new Divisa("€", "Moneda europea.");
        Divisa usdolar =   new Divisa( "USD", "Dolar de USA.");
        Divisa pesos = new Divisa( "$", "Argentina.");

        iReposDivisa.saveAll(List.of(euro, usdolar, pesos));

        //UBICACIONES

        Ubicacion u1  = new Ubicacion("Av. Atlântica", "100", "22010-000", "Brasil", "Rio De Janeiro");
        Ubicacion u2  = new Ubicacion("Rua Barata Ribeiro", "250", "22040-002", "Brasil", "Rio De Janeiro");
        Ubicacion u3  = new Ubicacion("Av. Nossa Senhora de Copacabana", "500", "22050-001", "Brasil", "Rio De Janeiro");
        Ubicacion u4  = new Ubicacion("Rua Figueiredo de Magalhães", "80", "22031-010", "Brasil", "Rio De Janeiro");
        Ubicacion u5  = new Ubicacion("Av. Vieira Souto", "900", "22420-004", "Brasil", "Rio De Janeiro");
        Ubicacion u6  = new Ubicacion("Rua Farme de Amoedo", "45", "22420-020", "Brasil", "Rio De Janeiro");
        Ubicacion u7  = new Ubicacion("Av. Borges de Medeiros", "1200", "22430-041", "Brasil", "Rio De Janeiro");
        Ubicacion u8  = new Ubicacion("Rua Visconde de Pirajá", "300", "22410-002", "Brasil", "Rio De Janeiro");
        Ubicacion u9  = new Ubicacion("Rua Garcia D’Ávila", "150", "22421-010", "Brasil", "Rio De Janeiro");
        Ubicacion u10 = new Ubicacion("Av. Delfim Moreira", "600", "22441-000", "Brasil", "Rio De Janeiro");

        ubicacionRepos.saveAll(List.of(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10));

        LocalDateTime desde = LocalDateTime.now();
        LocalDateTime hasta = desde.plusMonths(6);

// 🔹 5 publicaciones con 2 ambientes
        Publicacion p1 = new Publicacion( "Casa frente al mar", desde, hasta,
                4, 2, euro, 120.0, u1, casa);

        Publicacion p2 = new Publicacion( "Depto en Copacabana", desde, hasta,
                3, 2, euro, 95.0, u2, depto);

        Publicacion p3 = new Publicacion( "Hotel boutique", desde, hasta,
                2, 2, euro, 150.0, u3, hotel);

        Publicacion p4 = new Publicacion( "Loft moderno", desde, hasta,
                2, 2, euro, 110.0, u4, loft);

        Publicacion p5 = new Publicacion( "Depto con vista al mar", desde, hasta,
                4, 2, euro, 130.0, u5, depto);

// 🔹 5 publicaciones con 1 ambiente
        Publicacion p6 = new Publicacion( "Monoambiente céntrico", desde, hasta,
                2, 1, euro, 70.0, u6, depto);

        Publicacion p7 = new Publicacion( "Loft compacto", desde, hasta,
                2, 1, euro, 80.0, u7, loft);

        Publicacion p8 = new Publicacion( "Habitación hotelera", desde, hasta,
                1, 1, euro, 60.0, u8, hotel);

        Publicacion p9 = new Publicacion("Estudio turístico", desde, hasta,
                2, 1, euro, 75.0, u9, depto);

        Publicacion p10 = new Publicacion( "Mini loft urbano", desde, hasta,
                2, 1, euro, 85.0, u10, loft);

        reposPublicacion.saveAll(List.of(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));


    }



    @Override
    public void run(String... args) throws Exception {
        this.init();
    }

}
