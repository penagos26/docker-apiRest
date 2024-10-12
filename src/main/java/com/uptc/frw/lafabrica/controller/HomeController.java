package com.uptc.frw.lafabrica.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Home", description = "Endpoint de prueba")

public class HomeController {

    @GetMapping("/")
    @Operation(summary = "Obtiene un Hola Mundo", description = "Obtiene el hola mundo")
    public String redirectToSwagger() {
        return "Hello World poooo";
    }
}
