package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Asistencia;
import com.example.demo.repositorio.AsistenciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServicio {

    @Autowired
    public AsistenciaRepositorio asistenciaRepositorio;

    public Asistencia gurdarAsistencia(Asistencia datosAsistencia )throws Exception{
        try {
            return  this.asistenciaRepositorio.save(datosAsistencia);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Asistencia modificarAsitencia(Integer id , Asistencia datosAsistencia )throws Exception {
        try {
            Optional<Asistencia> buscarAsistencia = this.asistenciaRepositorio.findById(id);
            if (buscarAsistencia.isPresent()) {
                buscarAsistencia.get().setId(datosAsistencia.getId());
                buscarAsistencia.get().setEstado(datosAsistencia.getEstado());
                buscarAsistencia.get().setFechaAsistencia(datosAsistencia.getFechaAsistencia());
                return  this.asistenciaRepositorio.save(buscarAsistencia.get());
            }
            else {
                throw new Exception(mesajeApp.DONT_FOUND_ATTENDANCE.getTexto());
            }
        }
         catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
     public Asistencia buscarAsistenciaId(Integer id)throws Exception{
        try{
            Optional<Asistencia>buscarAsistencia = this.asistenciaRepositorio.findById(id);
            if(buscarAsistencia.isPresent()){
                return  buscarAsistencia.get();
            }else{
                throw  new Exception(mesajeApp.DONT_FOUND_ATTENDANCE.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
     }
     public List<Asistencia> buscarTodasAsistencia() throws Exception{
        try {
            return  this.asistenciaRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

     }


}
