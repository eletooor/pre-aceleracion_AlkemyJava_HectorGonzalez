package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PeliculaOSerieModel;
import com.example.demo.services.PeliculaOSerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class PeliculaOSerieController {

    @Autowired
    PeliculaOSerieService peliculaOSerieService;
    /*
     * @GetMapping() public ArrayList<PeliculaUtilModel> obtenerPeliculasOSeries() {
     * return this.peliculaOSerieService.obtenerPeliculasOSeries(); }
     */

    @GetMapping(path = "/{id}")
    public Optional<PeliculaOSerieModel> obtenerPeliculaOSerieById(@PathVariable("id") long id) {
        return this.peliculaOSerieService.obtenerPeliculaOSeriePorId(id);
    }

    @PostMapping() // CREACION
    public PeliculaOSerieModel guardarPeliculaOSerie(@RequestBody PeliculaOSerieModel peliculaOSerie) {
        return this.peliculaOSerieService.guardarPeliculaOSerie(peliculaOSerie);
    }

    @DeleteMapping(path = "/{id}") // ELIMINACION
    public String eliminarPeliculaOSerieById(@PathVariable("id") long id) {
        return this.peliculaOSerieService.eliminarPeliculaOSeriePorId(id);
    }

    @PatchMapping(path = "/{id}") // ACTUALIZACION
    public PeliculaOSerieModel actualizarPeliculaOSerieById(@PathVariable("id") long id,
            @RequestBody PeliculaOSerieModel peliculaOSerie) {
        return this.peliculaOSerieService.actualizarPeliculaOSeriePorId(id, peliculaOSerie);
    }

    @GetMapping()
    public ArrayList<PeliculaOSerieModel> obtenerPeliculasOSeriesSegunParametros(
            @RequestParam(name = "name", required = false) String titulo,
            @RequestParam(name = "genre", required = false) Long genero,
            @RequestParam(name = "order", required = false) String orden) {
        if (titulo != null) {
            System.out.println("TITULO!!");
            return this.peliculaOSerieService.obtenerPeliculaOSeriePorTitulo(titulo);
        } else if (genero != null) {
            System.out.println("GENERO!!");
            return this.peliculaOSerieService.obtenerPeliculasOSeriesPorGenero(genero);
        } else if (orden!=null&&(orden.equals("ASC") || orden.equals("DESC")) ) {
            System.out.println("ORDENANDO!!");
            return this.peliculaOSerieService.obtenerPeliculasOSeriesPorOrden(orden);
        } else {
            System.out.println("NO ORDENA!!");
            return this.peliculaOSerieService.obtenerPeliculasOSeries();
        }
    }

}
