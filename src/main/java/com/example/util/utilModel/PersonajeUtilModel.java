package com.example.util.utilModel;

import javax.persistence.Entity;


@Entity
public class PersonajeUtilModel {
    
    private long id;
    private String imagen;
    private String nombre;

    public PersonajeUtilModel() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
