package alojate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ImageService {
    @Value("${app.uploads.dir}")
    private String uploadsDir;

    public List<String> guardarTodas(List<MultipartFile> archivos, Long publicacionId) throws IOException {
        List<String> urls = new ArrayList<>();
        Path directorio = Paths.get(uploadsDir, String.valueOf(publicacionId));
        System.out.println("Intentando crear directorio en: {}" + directorio.toAbsolutePath());
        Files.createDirectories(directorio);
        System.out.println("Directorio creado exitosamente");

        for (MultipartFile archivo : archivos) {
            String nombre = UUID.randomUUID() + ".jpg";
            Files.copy(archivo.getInputStream(), directorio.resolve(nombre));
            urls.add("/imagenes/" + publicacionId + "/" + nombre);
        }
        return urls;
    }

}
