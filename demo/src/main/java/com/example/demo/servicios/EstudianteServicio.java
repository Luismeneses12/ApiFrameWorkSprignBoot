package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Estudiante;
import com.example.demo.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServicio {
 @Autowired
 public EstudianteRepositorio estudianteRepositorio;

 public Estudiante guardarEstudiante (Integer id, Estudiante datosEstudiante)throws Exception{
  try {
   Optional<Estudiante>buscarEstudinate = this.estudianteRepositorio.findById(id);
   if(buscarEstudinate.isPresent()){
    buscarEstudinate.get().setId(datosEstudiante.getId());
    buscarEstudinate.get().setGrado(datosEstudiante.getGrado());
    buscarEstudinate.get().setDireccion(datosEstudiante.getDireccion());
    buscarEstudinate.get().setDireccion(datosEstudiante.getDireccion());
    return this.estudianteRepositorio.save(buscarEstudinate.get());
   }else {
    throw  new Exception(mesajeApp.DONT_FOUND_STUDENT.getTexto());
   }

  } catch (Exception e) {
   throw new RuntimeException(e.getMessage());
  }
 }
public Estudiante buscarEstudianteId (Integer id)throws Exception{
  try{
   Optional<Estudiante>buscaeEstuiante = this.estudianteRepositorio.findById(id);
   if (buscaeEstuiante.isPresent()){
    return buscaeEstuiante.get();
   }else {
    throw new Exception(mesajeApp.DONT_FOUND_STUDENT.getTexto());
   }
  } catch (Exception e) {
   throw new RuntimeException(e.getMessage());
  }
}
public List<Estudiante>buscarTodoEstudiante() throws Exception{
  try{
   return this.estudianteRepositorio.findAll();
  } catch (Exception e) {
   throw new RuntimeException(e.getMessage());
  }

}
}

