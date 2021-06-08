package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GeneroModel;
import com.example.demo.services.GeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/generos")
public class GeneroController {
    @Autowired
    GeneroService generoService;

    @GetMapping()
    public ArrayList<GeneroModel> obtenerGeneros() {
        return this.generoService.obtenerGeneros();
    }

    @GetMapping(path = "/{id}")
    public Optional<GeneroModel> obtenerGeneroById(@PathVariable("id") long id) {
        return this.generoService.ObtenerGeneroPorId(id);
    }

    @PostMapping()
    public GeneroModel guardarGenero(@RequestBody GeneroModel genero) {
        return this.generoService.guardarGenero(genero);
    }

    @PutMapping(path = "/{id}")
    public GeneroModel actualizarGeneroById(@PathVariable("id") long id, @RequestBody GeneroModel genero) {
        return this.generoService.actualizarGeneroPorId(id, genero);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarGeneroById(@PathVariable("id") long id) {
        return this.generoService.eliminarPorId(id);
    }

}
