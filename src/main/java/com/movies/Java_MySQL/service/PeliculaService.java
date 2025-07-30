package com.movies.Java_MySQL.service;

import com.movies.Java_MySQL.model.Pelicula;
import com.movies.Java_MySQL.repository.PeliculaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository repository;

    public PeliculaService(PeliculaRepository repository) {
        this.repository = repository;
    }

    public List<Pelicula> todasLasPeliculas() {
        return repository.findAll();
    }

    public Pelicula crearPelicula(Pelicula pelicula) {
        return repository.save(pelicula);
    }
}
