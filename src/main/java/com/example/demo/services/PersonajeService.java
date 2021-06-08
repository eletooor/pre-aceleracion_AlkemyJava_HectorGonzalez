package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PersonajeModel;
import com.example.demo.repositories.PersonajeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;

    public ArrayList<PersonajeModel> obtenerPersonajes() {
        ArrayList<PersonajeModel> recuperadas = new ArrayList<>();
        recuperadas = (ArrayList<PersonajeModel>) personajeRepository.findAll();
        ArrayList<PersonajeModel> salida = new ArrayList<>();
        for (int i = 0; i < recuperadas.size(); i++) {
            PersonajeModel aux = new PersonajeModel();

            aux.setId(recuperadas.get(i).getId());
            aux.setImagen(recuperadas.get(i).getImagen());
            aux.setNombre(recuperadas.get(i).getNombre());
            salida.add(i, aux);
        }
        return salida;
    }

    // CREAR
    public PersonajeModel guardarPersonaje(PersonajeModel personaje) {
        return personajeRepository.save(personaje);
    }

    // ELIMINAR
    public String eliminarPersonajePorId(long id) {
        try {
            this.personajeRepository.deleteById(id);
            return "El personaje " + id + " ha sido eliminado con exito!";
        } catch (Exception e) {
            return "No se ha podido eliminar al personaje " + id + "\n\nERROR:\n" + e;
        }
    }

    public Optional<PersonajeModel> obtenerPersonajePorId(long id) {
        return this.personajeRepository.findById(id);
    }

    public ArrayList<PersonajeModel> obtenerPersonajePorNombre(String nombre) {
        return this.personajeRepository.findByNombre(nombre);
    }

    public ArrayList<PersonajeModel> obtenerPersonajePorEdad(int edad) {
        return this.personajeRepository.findByEdad(edad);
    }

    public ArrayList<PersonajeModel> obtenerPersonajePorPeliculaOSerie(Long id) {
        System.out.println("LLEGA HASTA ACA");
        return this.personajeRepository.findByPeliculaOSerieId(id);
    }

    // ACTUALIZAR
    public PersonajeModel actualizarPersonajePorId(Long id, PersonajeModel personaje) {
        personaje.setId(id);
        return this.personajeRepository.save(personaje);
    }

}
