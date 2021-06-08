package com.example.demo.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "PeliculaOSerie")
public class PeliculaOSerieModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String imagen;
    private String titulo;

    @Temporal(TemporalType.DATE) // FORMATO DE FECHA
    private Date fechaCreacion;

    @Min(1) // VALIDACION DEL MINIMO
    @Max(5) // VALIDACION DEL MAXIMO
    private Integer calificacion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_genero")
    private GeneroModel genero;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name = "Peli_Personaje", joinColumns = @JoinColumn(name = "id_Peli"), inverseJoinColumns = @JoinColumn(name = "id_Personaje"))
    private Set<PersonajeModel> personajesAsociados = new HashSet<>();

    // GETTERS Y SETTERS
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Set<PersonajeModel> getPersonajesAsociados() {
        return personajesAsociados;
    }

    public void setPersonajesAsociados(Set<PersonajeModel> personajesAsociados) {
        this.personajesAsociados = personajesAsociados;
    }

    public Integer getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }

    public GeneroModel getGenero() {
        return genero;
    }

    public void setGenero(GeneroModel genero) {
        this.genero = genero;
    }

}
