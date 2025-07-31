package com.movies.Java_MySQL.repository;

import com.movies.Java_MySQL.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
    List<Pelicula> findByTituloContaining(String titulo);
    List<Pelicula> findByGenero_Nombre(String genero);

    // Nueva consulta ordenada por ID ascendente
    List<Pelicula> findAllByOrderByIdAsc();
    Optional<Pelicula> findById(Long id);
}
