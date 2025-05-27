package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Materia;
import com.example.demo.repositorio.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaServicio {
    @Autowired
    public MateriaRepositorio materiaRepositorio;

    public Materia guardaMateria (Materia datosMateria)throws Exception{
        try {
            return  this.materiaRepositorio.save(datosMateria);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Materia modificarMateria(Integer id, Materia datosmateria)throws Exception{
        try{
            Optional<Materia>buscarMateria = this.materiaRepositorio.findById(id);
            if (buscarMateria.isPresent()){
                buscarMateria.get().setId(datosmateria.getId());
                buscarMateria.get().setNombreMateria(datosmateria.getNombreMateria());
                return this.materiaRepositorio.save(buscarMateria.get());

            }else {
                throw  new Exception(mesajeApp.DONT_FOUND_SUBJECT.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Materia buscarMateriaId (Integer id)throws Exception{
        try{
            Optional<Materia>bucarMateria= this.materiaRepositorio.findById(id);
            if (bucarMateria.isPresent()){
                return bucarMateria.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_SUBJECT.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Materia> todasMateria()throws Exception{
        try {
            return  this.materiaRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
