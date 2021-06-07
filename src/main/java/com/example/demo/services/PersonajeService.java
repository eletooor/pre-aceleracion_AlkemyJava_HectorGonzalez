package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.PersonajeModel;
import com.example.demo.repositories.PersonajeRepository;

@Service
public class PersonajeService {
    @Autowired
    PersonajeRepository personajeRepository;
/*********** DEBIDO A LA NECESIDAD DE COMBINAR LAS LLAMADAS EN
 * UN MISMO ENDPOINT SE HA OPTADO POR CAMBIAR LA ESTRATEGIA***********
 * 
    public ArrayList<PersonajeUtilModel> obtenerPersonajes() {
        ArrayList<PersonajeModel> recuperadas = new ArrayList<>();
        recuperadas = (ArrayList<PersonajeModel>) personajeRepository.findAll();
        ArrayList<PersonajeUtilModel> salida = new ArrayList<>();

        for (int i = 0; i < recuperadas.size(); i++) {
            PersonajeUtilModel aux = new PersonajeUtilModel();

            aux.setId(recuperadas.get(i).getId());
            aux.setImagen(recuperadas.get(i).getImagen());
            aux.setNombre(recuperadas.get(i).getNombre());
            salida.add(i, aux);
        }
        return salida;

    }
    A CONTINUACION, ALTERNATIVA A LA RESOLUCION
**************************************************/
    public ArrayList<PersonajeModel> obtenerPersonajes(){
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

    public PersonajeModel guardarPersonaje(PersonajeModel personaje) {
        return personajeRepository.save(personaje);
    }

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

    public ArrayList<PersonajeModel> obtenerPersonajePorPeliculaOSerie(Long id){
        System.out.println("LLEGA HASTA ACA");
        return this.personajeRepository.findByPeliculaOSerieId(id);
    }
    
    /*
     * METODO IMPLEMENTADO INDIRECTAMENTE EN GUARDAR PERSONAJE public PersonajeModel
     * actualizarPersonajePorId( long id, PersonajeModel personaje){ return
     * this.personajeRepository.save(personaje); }
     */
}
