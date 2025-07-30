package com.movies.Java_MySQL.controller;

import com.movies.Java_MySQL.model.Pelicula;
import com.movies.Java_MySQL.service.PeliculaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {
    private final PeliculaService service;

    public PeliculaController(PeliculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Pelicula> obtenerTodas() {
        return service.todasLasPeliculas();
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return service.crearPelicula(pelicula);
    }
}
