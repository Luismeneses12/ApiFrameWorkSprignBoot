package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Calificacion;
import com.example.demo.modelos.Curso;
import com.example.demo.repositorio.CursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {
    @Autowired
    public CursoRepositorio cursoRepositorio;

    public  Curso guardarUsuario(Curso datosCurso)throws Exception{
        try{
            return this.cursoRepositorio.save(datosCurso);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    public  Curso modificaCurso (Integer id , Curso datosCurso)throws Exception{
        try{
            Optional<Curso>buscarCurso = this.cursoRepositorio.findById(id);
            if (buscarCurso.isPresent()){
                buscarCurso.get().setId(datosCurso.getId());
                buscarCurso.get().setNombreCusrso(datosCurso.getNombreCusrso());
                return  this.cursoRepositorio.save(buscarCurso.get());
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_COURSE.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public Curso buscarcursoId(Integer id)throws Exception{
        try{
            Optional<Curso>buscarCurso = this.cursoRepositorio.findById(id);
            if(buscarCurso.isPresent()){
                return buscarCurso.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_COURSE.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    public List<Curso>buscarTodosCurso()throws Exception{
        try{
            return this.cursoRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
