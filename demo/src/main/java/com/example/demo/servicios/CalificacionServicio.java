package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Calificacion;
import com.example.demo.repositorio.CalificaioneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CalificacionServicio {
    @Autowired
    public CalificaioneRepositorio calificaioneRepositorio;

    public Calificacion guardarCalificacion(Calificacion datosCalificacion)throws Exception{
        try{
            return this.calificaioneRepositorio.save(datosCalificacion);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Calificacion modificarCalifiacaciones(Integer id, Calificacion datosCalificacion)throws Exception{
        try{
            Optional<Calificacion>buscarCalificacion = this.calificaioneRepositorio.findById(id);
            if(buscarCalificacion.isPresent()){
                buscarCalificacion.get().setId(datosCalificacion.getId());
                buscarCalificacion.get().setNota(datosCalificacion.getNota());
                buscarCalificacion.get().setFechaEvaluacion(datosCalificacion.getFechaEvaluacion());
                return  this.calificaioneRepositorio.save(buscarCalificacion.get());
            }else {
                throw  new Exception(mesajeApp.DONT_FOUND_GRADE.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Calificacion buscarCalificacionId(Integer id) throws Exception{
        try{
            Optional<Calificacion>buscarCalificacion= this.calificaioneRepositorio.findById(id);
            if (buscarCalificacion.isPresent()){
                return buscarCalificacion.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_GRADE.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Calificacion>buscarTodasCalificacion()throws Exception{
        try{
            return  this.calificaioneRepositorio.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
