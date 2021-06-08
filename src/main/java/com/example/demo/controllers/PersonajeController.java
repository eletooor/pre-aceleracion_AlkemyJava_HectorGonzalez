package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PersonajeModel;
import com.example.demo.services.PersonajeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class PersonajeController {

    @Autowired
    PersonajeService personajeService;

    // CREACION
    @PostMapping() // with id for update, only data for new
    public PersonajeModel guardarPersonaje(@RequestBody PersonajeModel personaje) {

        return this.personajeService.guardarPersonaje(personaje);
    }

    // ELIMINACION
    @DeleteMapping(path = "/{id}")
    public String eliminarPersonajeById(@PathVariable("id") long id) {
        return this.personajeService.eliminarPersonajePorId(id);
    }

    // ACTUALIZAR
    @PutMapping(path = "/{id}")
    public PersonajeModel actualizarPersonajeById(@PathVariable("id") Long id, @RequestBody PersonajeModel personaje) {
        return this.personajeService.actualizarPersonajePorId(id, personaje);
    }

    @GetMapping(path = "/{id}")
    public Optional<PersonajeModel> obtenerPersonajeById(@PathVariable("id") long id) {
        return this.personajeService.obtenerPersonajePorId(id);
    }

    @GetMapping()
    public ArrayList<PersonajeModel> obtenerPersonajesSegunParametros(
            @RequestParam(required = false, name = "name") String nombre,
            @RequestParam(required = false, name = "age") Integer edad,
            @RequestParam(required = false, name = "movies") Long pelicula) {
        if (nombre != null) {
            return this.personajeService.obtenerPersonajePorNombre(nombre);

        } else if (edad != null) {
            return this.personajeService.obtenerPersonajePorEdad(edad);

        } else if (pelicula != null) {
            return this.personajeService.obtenerPersonajePorPeliculaOSerie(pelicula);

        } else {
            return this.personajeService.obtenerPersonajes();
        }
    }

}
