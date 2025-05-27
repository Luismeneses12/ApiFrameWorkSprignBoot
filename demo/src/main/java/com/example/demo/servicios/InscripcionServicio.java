package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Estudiante;
import com.example.demo.modelos.Inscripciones;
import com.example.demo.repositorio.InscripcionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscripcionServicio {
    @Autowired
    public InscripcionRepositorio inscripcionRepositorio;

    public Inscripciones guardaInscripcion ( Inscripciones datosInscripcion)throws Exception{
        try{
            return  this.inscripcionRepositorio.save(datosInscripcion);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Inscripciones BuscarInscripcionId (Integer id,Inscripciones datosInscripcion)throws Exception{
        try {
            Optional<Inscripciones>buscarIncripcion = this.inscripcionRepositorio.findById(id);
            if(buscarIncripcion.isPresent()){
               buscarIncripcion.get().setId(datosInscripcion.getId());
               buscarIncripcion.get().setFechaInscripcion(datosInscripcion.getFechaInscripcion());
               return  this.inscripcionRepositorio.save(buscarIncripcion.get());
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_INSCRIPTION.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
     public Inscripciones buscarIncripcionId (Integer id)throws Exception{
        try{
            Optional<Inscripciones>buscarInscripcion= this.inscripcionRepositorio.findById(id);
            if (buscarInscripcion.isPresent()){
                return buscarInscripcion.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_INSCRIPTION.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

     }

    public List<Inscripciones> buscarTodoIncripcion() throws Exception{
        try{
            return  this.inscripcionRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
