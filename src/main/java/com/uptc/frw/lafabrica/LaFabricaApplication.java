package com.uptc.frw.lafabrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class LaFabricaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaFabricaApplication.class, args);
    }


    @Bean
    public ApplicationListener<ApplicationReadyEvent> applicationReadyEventApplicationListener() {
        return event -> {
            String swaggerUrl = "http://localhost:8080/swagger-ui.html";

            // Verifica si la aplicación se está ejecutando en un entorno gráfico
            if (Desktop.isDesktopSupported()) {
                try {
                    // Intenta abrir el navegador
                    Desktop.getDesktop().browse(new URI(swaggerUrl));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                // Si no se puede abrir el navegador, notifica al usuario
                System.out.println("La aplicación está corriendo. Abre el siguiente enlace para acceder a Swagger: " + swaggerUrl);
            }
        };
    }
}
