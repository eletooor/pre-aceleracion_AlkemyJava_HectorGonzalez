package com.example.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "personajes")
public class PersonajeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String imagen;
    private String nombre;
    private Integer edad;
    private Float peso;
    private String historia;

    @JsonBackReference
    @ManyToMany(mappedBy = "personajesAsociados")
    private Set<PeliculaOSerieModel> peliculaOSerie = new HashSet<>();

  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
   // @JsonManagedReference
  // @JsonBackReference
    public Set<PeliculaOSerieModel> getPeliculaOSerie() {
        return peliculaOSerie;
    }

    public void setPeliculaOSerie(Set<PeliculaOSerieModel> peliculaOSerie) {
        this.peliculaOSerie = peliculaOSerie;
    }

    
}
