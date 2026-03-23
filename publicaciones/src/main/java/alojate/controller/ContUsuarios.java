package alojate.controller;


import alojate.models.dtos.input.PublicacionDTO;
import alojate.models.dtos.input.QueryParamsPublicacion;
import alojate.models.dtos.output.FavoritoDTO;
import alojate.models.dtos.output.OutPublicacionSimple;
import alojate.service.FavoritoService;
import alojate.service.ImageService;
import alojate.service.PublicacionService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:8080")
public class ContUsuarios {

    private final PublicacionService publicacionService;
    private final FavoritoService favoritoService;


    public ContUsuarios(PublicacionService publicacionService, FavoritoService favoritoService) {
        this.publicacionService = publicacionService;
        this.favoritoService = favoritoService;
    }


    @PostMapping("/api/publicaciones")
    public void alta(@RequestBody PublicacionDTO dto){
        publicacionService.altaDeDatos(dto);
    }

    @PostMapping(value = "/api/publicaciones", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<PublicacionDTO> crearPublicacion(
            @RequestPart("datos") PublicacionDTO datos,
            @RequestPart(value = "imagenes", required = false) List<MultipartFile> imagenes) throws IOException {
        publicacionService.alta(datos, imagenes);
        return ResponseEntity.ok(datos);
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
        @RequestParam (required=false)Integer adultos)
    {
        QueryParamsPublicacion filtro = new QueryParamsPublicacion(pais, ciudad, checkIn, checkOut, adultos);
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

    @PostMapping("/api/favoritos")
    public void nuevoFavorito(@RequestParam String user_id,
                              @RequestParam String publicacion_id){
        System.out.println("ESTOY EN EL CONTROLADOR nuevoFavorito.");
        Long pub_id = Long.parseLong(publicacion_id);
        favoritoService.agregarFavorito(user_id,pub_id);
    }

    @GetMapping("/api/favoritos")
    public List<FavoritoDTO> favoritos(String user_id){
        return favoritoService.favoritos(user_id);
    }




    @GetMapping("/api/publicaciones-disponibles/")
    public List<String> devolverDisponibles(){
        return publicacionService.obtenerDisponibles();
    }
}
