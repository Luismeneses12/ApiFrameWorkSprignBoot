package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Curso;
import com.example.demo.modelos.Docente;
import com.example.demo.repositorio.DocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocneteServicio {
    @Autowired
    public DocenteRepositorio docenteRepositorio;

    public Docente gurdarDocente (Docente datosDocente)throws Exception{
        try{
            return  this.docenteRepositorio.save(datosDocente);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public  Docente modifiacarDocente (Integer id, Docente datosDocente)throws Exception{
        try {
            Optional<Docente>burcarDocente = this.docenteRepositorio.findById(id);
            if(burcarDocente.isPresent()){
                burcarDocente.get().setId(datosDocente.getId());
                burcarDocente.get().setEspecialidad(datosDocente.getEspecialidad());
                return this.docenteRepositorio.save(burcarDocente.get());
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_TEACHER.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public  Docente burcarDocenteId (Integer id)throws Exception{
        try{
            Optional<Docente>burcarDocente = this.docenteRepositorio.findById(id);
            if (burcarDocente.isPresent()){
                 return burcarDocente.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_TEACHER.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Docente>burcarTodosDocente() throws Exception{
        try{
            return this.docenteRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
