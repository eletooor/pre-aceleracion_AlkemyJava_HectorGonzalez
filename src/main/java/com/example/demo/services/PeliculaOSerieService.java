package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PeliculaOSerieModel;
import com.example.demo.repositories.PeliculaOSerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeliculaOSerieService {
    @Autowired
    PeliculaOSerieRepository peliculaOSerieRepository;

    public ArrayList<PeliculaOSerieModel> obtenerPeliculasOSeries() {
        ArrayList<PeliculaOSerieModel> recuperadas = (ArrayList<PeliculaOSerieModel>) this.peliculaOSerieRepository
                .findAll();
        ArrayList<PeliculaOSerieModel> salida = new ArrayList<>();
        for (int i = 0; i < recuperadas.size(); i++) {
            PeliculaOSerieModel aux = new PeliculaOSerieModel();
            aux.setId(recuperadas.get(i).getId());
            aux.setImagen(recuperadas.get(i).getImagen());
            aux.setTitulo(recuperadas.get(i).getTitulo());
            aux.setFechaCreacion(recuperadas.get(i).getFechaCreacion());
            salida.add(i, aux);
        }
        return salida;
    }

    public PeliculaOSerieModel guardarPeliculaOSerie(PeliculaOSerieModel peliculaOSerie) {
        return this.peliculaOSerieRepository.save(peliculaOSerie);
    }

    public Optional<PeliculaOSerieModel> obtenerPeliculaOSeriePorId(long id) {
        return this.peliculaOSerieRepository.findById(id);
    }

    public String eliminarPeliculaOSeriePorId(long id) {
        try {
            this.peliculaOSerieRepository.deleteById(id);
            return "La Pelicula o Serie " + id + " se ha eliminado con exito!";
        } catch (Exception e) {
            return "No se ha podido eliminar la pelicula o serie " + id + "\n\n#ERROR:\n" + e;
        }

    }

    public PeliculaOSerieModel actualizarPeliculaOSeriePorId(long id, PeliculaOSerieModel peliculaOSerie) {
        peliculaOSerie.setId(id);
        return this.peliculaOSerieRepository.save(peliculaOSerie);

    }

    public ArrayList<PeliculaOSerieModel> obtenerPeliculaOSeriePorTitulo(String titulo) {
        return this.peliculaOSerieRepository.findByTitulo(titulo);
    }

    public ArrayList<PeliculaOSerieModel> obtenerPeliculasOSeriesPorGenero(Long id) {
        return this.peliculaOSerieRepository.findByGeneroId(id);
    }

    public ArrayList<PeliculaOSerieModel> obtenerPeliculasOSeriesPorOrden(String orden) {
        if (orden.equals("ASC")) {
            System.out.println("ASC");
            return this.peliculaOSerieRepository.findByOrderByFechaCreacionAsc();
        } else {
            System.out.println("DESC");
            return this.peliculaOSerieRepository.findByOrderByFechaCreacionDesc();
        }
    }
}
