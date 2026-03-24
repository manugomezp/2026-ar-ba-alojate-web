package alojate.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class FileSystemConfig implements WebMvcConfigurer {

    @Value("${app.uploads.dir}")
    private String uploadsDir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        System.out.println("uploads dir: " + uploadsDir);
        System.out.println("Resource location: " + "file:///" + uploadsDir + "/");

        // Verificar que el directorio existe
        Path path = Paths.get(uploadsDir);
        System.out.println("Directorio existe: " + Files.exists(path));
        System.out.println("Directorio es legible: " + Files.isReadable(path));

        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:///" + uploadsDir + "/");
    }
}
