package com.movies.Java_MySQL.service;

import com.movies.Java_MySQL.model.Pelicula;
import com.movies.Java_MySQL.model.Genero;
import com.movies.Java_MySQL.repository.PeliculaRepository;
import com.movies.Java_MySQL.repository.GeneroRepository;
import jakarta.transaction.Transactional;
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


    public List<Pelicula> todasLasPeliculas() {
        return peliculaRepository.findAllByOrderByIdAsc();
    }


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
    public Pelicula obtenerPeliculaPorId(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada"));
    }
    @Transactional
    public Pelicula actualizarPelicula(Long id, Pelicula peliculaActualizada) {
        // 1. Buscar la película existente
        Pelicula peliculaExistente = peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Película no encontrada con ID: " + id));

        // 2. Actualizar campos
        if (peliculaActualizada.getTitulo() != null) {
            peliculaExistente.setTitulo(peliculaActualizada.getTitulo());
        }
        if (peliculaActualizada.getAnio() != null) {
            peliculaExistente.setAnio(peliculaActualizada.getAnio());
        }
        if (peliculaActualizada.getDirector() != null) {
            peliculaExistente.setDirector(peliculaActualizada.getDirector());
        }
        if (peliculaActualizada.getPuntuacionImdb() != null) {
            peliculaExistente.setPuntuacionImdb(peliculaActualizada.getPuntuacionImdb());
        }

        // 3. Actualizar género si se proporciona
        if (peliculaActualizada.getGeneroNombre() != null) {
            String nuevoGeneroNombre = peliculaActualizada.getGeneroNombre();
            Genero genero = generoRepository.findByNombre(nuevoGeneroNombre);

            if (genero == null) {
                genero = new Genero(nuevoGeneroNombre);
                generoRepository.save(genero);
            }

            peliculaExistente.setGenero(genero);
        }

        // 4. Guardar cambios
        return peliculaRepository.save(peliculaExistente);
    }
    @Transactional
    public void eliminarPelicula(Long id) {
        Pelicula pelicula = obtenerPeliculaPorId(id);
        peliculaRepository.delete(pelicula);
    }

    // Aquí puedes añadir más métodos: actualización, borrado, búsquedas específicas, etc.
}

