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

}
