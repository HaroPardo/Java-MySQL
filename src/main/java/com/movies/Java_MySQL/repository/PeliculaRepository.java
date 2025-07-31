package com.movies.Java_MySQL.repository;

import com.movies.Java_MySQL.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByTituloContaining(String titulo);
    List<Pelicula> findByGenero_Nombre(String genero);
}
