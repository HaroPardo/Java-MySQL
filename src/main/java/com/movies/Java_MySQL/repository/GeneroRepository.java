package com.movies.Java_MySQL.repository;

import com.movies.Java_MySQL.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
    Genero findByNombre(String nombre);
}
