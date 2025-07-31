package com.movies.Java_MySQL.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"genero", "hibernateLazyInitializer", "handler"})
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genero_id")
    @JsonIgnoreProperties("peliculas")
    private Genero genero;
    @JsonCreator
    public Pelicula(@JsonProperty("titulo") String titulo,
                    @JsonProperty("anio") Integer anio,
                    @JsonProperty("director") String director,
                    @JsonProperty("puntuacionImdb") Double puntuacionImdb,
                    @JsonProperty("genero") String generoNombre) {
        this.titulo = titulo;
        this.anio = anio;
        this.director = director;
        this.puntuacionImdb = puntuacionImdb;
        this.genero = new Genero(generoNombre);
    }
    public Pelicula() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Double getPuntuacionImdb() {
        return puntuacionImdb;
    }

    public void setPuntuacionImdb(Double puntuacionImdb) {
        this.puntuacionImdb = puntuacionImdb;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}
