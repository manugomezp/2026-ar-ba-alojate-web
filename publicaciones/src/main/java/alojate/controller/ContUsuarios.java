package alojate.controller;


import alojate.models.dtos.input.PublicacionDTO;
import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.models.dtos.output.FavoritoDTO;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.service.PublicacionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8080")
public class ContUsuarios {

    private final PublicacionService publicacionService;


    public ContUsuarios(PublicacionService publicacionService) {
        this.publicacionService = publicacionService;
    }


    @PostMapping("/api/publicaciones")
    public void alta(@RequestBody PublicacionDTO dto){
        publicacionService.alta(dto);
    }

//    @GetMapping("/api/publicaciones")
//    public List<OutPublicacionSimple> devolver(){
//        List<OutPublicacionSimple> lista = new ArrayList<>();
//
//        OutPublicacionSimple simpleUno = new OutPublicacionSimple("none", "4.9", "USD25", "Una descripción","depto" );
//        OutPublicacionSimple simpleDos = new OutPublicacionSimple("none", "3.6", "USD15", "Otra descripcion", "depto" );
//
//        lista.add(simpleUno);
//        lista.add(simpleDos);
//        lista.add(
//                publicacionService.
//                toOutPublicacionSimple(publicacionService.publicacionesDisponibles.get(0))
//                );
//
//
//        System.out.println("SE DEVUELVEN LAS PUBLICACIONES EN FORMATO JSON?");
//
//        return lista;
//    }
    @GetMapping("/api/publicaciones")
    public List<OutPublicacionSimple> obtenerPublicaciones(
        @RequestParam (required=false)String pais ,
        @RequestParam (required=false)String ciudad,
        @RequestParam (required=false)String checkIn,
        @RequestParam (required=false)String checkOut,
        @RequestParam (required=false)Integer adultos,
        @RequestParam (required=false) Integer ambientes)
    {
        QueryParamsPublicacion filtro = new QueryParamsPublicacion(pais, ciudad, checkIn, checkOut, adultos, ambientes);
        return publicacionService.obtener(filtro);
    }

    @GetMapping("/api/multimedia")
    public ResponseEntity<Resource> getImagen(@RequestParam Long id) {
        String filename = publicacionService.getImageById(id);
        Resource resource = new ClassPathResource(filename);

        if (!resource.exists() || !resource.isReadable()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }

    @PostMapping("/api/favorito")
    public void nuevoFavorito(@RequestParam String user_id,
                              @RequestParam Long publicacion_id){
        publicacionService.agregarFavorito(user_id, publicacion_id);
    }

    @GetMapping("/api/favorito")
    public List<FavoritoDTO> favoritos(String user_id){
        return publicacionService.favoritos(user_id);
    }




    @GetMapping("/api/publicaciones-disponibles/")
    public List<String> devolverDisponibles(){
        return publicacionService.obtenerDisponibles();
    }
}
