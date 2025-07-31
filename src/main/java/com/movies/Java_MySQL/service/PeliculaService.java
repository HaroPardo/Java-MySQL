package com.movies.Java_MySQL.service;

import com.movies.Java_MySQL.model.Pelicula;
import com.movies.Java_MySQL.model.Genero;
import com.movies.Java_MySQL.repository.PeliculaRepository;
import com.movies.Java_MySQL.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {
    private final PeliculaRepository peliculaRepository;
    private final GeneroRepository generoRepository;

    public PeliculaService(PeliculaRepository peliculaRepository,
                           GeneroRepository generoRepository) {
        this.peliculaRepository = peliculaRepository;
        this.generoRepository = generoRepository;
    }

    /**
     * Devuelve todas las películas registradas.
     */
    public List<Pelicula> todasLasPeliculas() {
        return peliculaRepository.findAll();
    }

    /**
     * Crea una nueva película; busca o crea el género antes de guardar.
     */
    public Pelicula crearPelicula(Pelicula pelicula) {
        // 1. Buscar o crear el género por nombre
        String nombreGenero = pelicula.getGeneroNombre();
        Genero genero = generoRepository.findByNombre(nombreGenero);

        if (genero == null) {
            genero = new Genero(nombreGenero);
            generoRepository.save(genero);
        }

        // 2. Asignar la entidad Genero a la película
        pelicula.setGenero(genero);

        // 3. Persistir la película
        return peliculaRepository.save(pelicula);
    }

    // Aquí puedes añadir más métodos: actualización, borrado, búsquedas específicas, etc.
}

