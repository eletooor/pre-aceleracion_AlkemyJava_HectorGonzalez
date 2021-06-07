package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.GeneroModel;
import com.example.demo.repositories.GeneroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService {
    @Autowired
    GeneroRepository generoRepository;

    //OBTENER TODOS
    public ArrayList<GeneroModel> obtenerGeneros(){
        return (ArrayList<GeneroModel>)this.generoRepository.findAll();
    }

    //OBTENER POR ID
    public Optional<GeneroModel> ObtenerGeneroPorId(Long id){
        return this.generoRepository.findById(id);
    }
    
    //CREAR NUEVO
    public GeneroModel guardarGenero(GeneroModel genero){
        return this.generoRepository.save(genero);
    }

    //ACTUALIZAR POR ID
    public GeneroModel actualizarGeneroPorId(Long id, GeneroModel genero){
        genero.setId(id);
        return this.generoRepository.save(genero);
    }

    //ELIMINAR POR ID
    public String eliminarPorId(Long id){
        try{
            this.generoRepository.deleteById(id);
            return "El genero " + id + " se ha eliminado con exito!";
        }catch(Exception e){
            return "No se ha podido eliminar el genero " + id + "\n\n#ERROR:\n" + e;
        }
    }
}
