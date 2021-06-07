package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.PeliculaOSerieModel;

import org.springframework.data.repository.CrudRepository;

public interface PeliculaOSerieRepository extends CrudRepository<PeliculaOSerieModel, Long > {
    
    public abstract ArrayList<PeliculaOSerieModel> findByTitulo(String titulo);

    public abstract ArrayList<PeliculaOSerieModel> findByGeneroId(Long id_genero);

    public abstract ArrayList<PeliculaOSerieModel> findByOrderByFechaCreacionDesc();

    public abstract ArrayList<PeliculaOSerieModel> findByOrderByFechaCreacionAsc();
}
