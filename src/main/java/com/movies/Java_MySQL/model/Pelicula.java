package com.movies.Java_MySQL.model;

import jakarta.persistence.*;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private Integer anio;
    private String director;
    @Column(name = "puntuacion_imdb")
    private Double puntuacionImdb;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    // Getters y Setters
}
