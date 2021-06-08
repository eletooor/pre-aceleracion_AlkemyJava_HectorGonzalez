package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.PersonajeModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonajeRepository extends CrudRepository<PersonajeModel, Long> {

    public abstract ArrayList<PersonajeModel> findByNombre(String nombre);

    public abstract ArrayList<PersonajeModel> findByEdad(int edad);

    public abstract ArrayList<PersonajeModel> findByPeliculaOSerieId(Long id);

    public abstract ArrayList<PersonajeModel> findByPeso(Float peso);
}