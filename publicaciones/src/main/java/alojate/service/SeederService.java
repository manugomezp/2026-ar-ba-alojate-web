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

        Ubicacion u1  = new Ubicacion("Av. Atlântica", "100", "22010-000", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u2  = new Ubicacion("Rua Barata Ribeiro", "250", "22040-002", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u3  = new Ubicacion("Av. Nossa Senhora de Copacabana", "500", "22050-001", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u4  = new Ubicacion("Rua Figueiredo de Magalhães", "80", "22031-010", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u5  = new Ubicacion("Av. Vieira Souto", "900", "22420-004", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u6  = new Ubicacion("Rua Farme de Amoedo", "45", "22420-020", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u7  = new Ubicacion("Av. Borges de Medeiros", "1200", "22430-041", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u8  = new Ubicacion("Rua Visconde de Pirajá", "300", "22410-002", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u9  = new Ubicacion("Rua Garcia D’Ávila", "150", "22421-010", "Brasil", "Rio De Janeiro", "Rio De Janeiro");
        Ubicacion u10 = new Ubicacion("Av. Delfim Moreira", "600", "22441-000", "Brasil", "Rio De Janeiro", "Rio De Janeiro");

        ubicacionRepos.saveAll(List.of(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10));

        Ubicacion u11 = new Ubicacion("Av. Corrientes", "1200", "1043",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u12 = new Ubicacion("Av. Santa Fe", "2300", "1123",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u13 = new Ubicacion("Av. Cabildo", "3400", "1429",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u14 = new Ubicacion("Av. Rivadavia", "5600", "1406",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u15 = new Ubicacion("Av. Callao", "900", "1023",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u16 = new Ubicacion("Av. Belgrano", "1800", "1094",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u17 = new Ubicacion("Av. Libertador", "4500", "1426",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u18 = new Ubicacion("Av. Pueyrredón", "1600", "1118",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u19 = new Ubicacion("Av. Scalabrini Ortiz", "2400", "1425",
                "Argentina", "Buenos Aires", "Buenos Aires");

        Ubicacion u20 = new Ubicacion("Av. Juan B. Justo", "5200", "1414",
                "Argentina", "Buenos Aires", "Buenos Aires");

        ubicacionRepos.saveAll(List.of(u11, u12, u13, u14, u15, u16, u17, u18, u19, u20));


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

        LocalDateTime desdeBA = LocalDateTime.now();
        LocalDateTime hastaBA = desdeBA.plusMonths(6);

// 🔹 5 publicaciones con 2 ambientes
        Publicacion p11 = new Publicacion( "Depto en Microcentro", desdeBA, hastaBA,
                4, 2, euro, 90.0, u11, depto);

        Publicacion p12 = new Publicacion( "Casa urbana", desdeBA, hastaBA,
                5, 2, euro, 140.0, u12, casa);

        Publicacion p13 = new Publicacion( "Hotel céntrico", desdeBA, hastaBA,
                3, 2, euro, 160.0, u13, hotel);

        Publicacion p14 = new Publicacion("Loft en barrio histórico", desdeBA, hastaBA,
                2, 2, euro, 110.0, u14, loft);

        Publicacion p15 = new Publicacion("Depto familiar", desdeBA, hastaBA,
                4, 2, euro, 100.0, u15, depto);

// 🔹 5 publicaciones con 1 ambiente
        Publicacion p16 = new Publicacion( "Monoambiente moderno", desdeBA, hastaBA,
                2, 1, euro, 65.0, u16, depto);

        Publicacion p17 = new Publicacion( "Loft compacto en Palermo", desdeBA, hastaBA,
                2, 1, euro, 85.0, u17, loft);

        Publicacion p18 = new Publicacion( "Habitación de hotel", desdeBA, hastaBA,
                1, 1, euro, 70.0, u18, hotel);

        Publicacion p19 = new Publicacion( "Estudio turístico", desdeBA, hastaBA,
                2, 1, euro, 75.0, u19, depto);

        Publicacion p20 = new Publicacion( "Mini loft urbano", desdeBA, hastaBA,
                2, 1, euro, 80.0, u20, loft);

        reposPublicacion.saveAll(List.of(p11,p12,p13,p14,p15,p16,p17,p18,p19,p20));



    }


    @Override
    public void run(String... args) throws Exception {
        this.init();
    }

}
