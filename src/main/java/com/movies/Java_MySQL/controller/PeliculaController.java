package com.movies.Java_MySQL.controller;

import com.movies.Java_MySQL.model.Pelicula;
import com.movies.Java_MySQL.service.PeliculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable Long id) {
        return service.obtenerPeliculaPorId(id);
    }

    // Actualizar película
    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(
            @PathVariable Long id,
            @RequestBody Pelicula peliculaActualizada) {
        return service.actualizarPelicula(id, peliculaActualizada);
    }

    // Eliminar película
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable Long id) {
        service.eliminarPelicula(id);
        return ResponseEntity.ok().body(Map.of(
                "status", "success",
                "message", "Película con ID " + id + " eliminada correctamente"
        ));
    }

    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return service.crearPelicula(pelicula);
    }
}
