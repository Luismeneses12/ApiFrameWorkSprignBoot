package com.example.demo.control;

import com.example.demo.modelos.Calificacion;
import com.example.demo.servicios.CalificacionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calificacion")
public class CalificacionControl {
    @Autowired
    public CalificacionServicio calificacionServicio;

    @PostMapping()
    public ResponseEntity<?>gurdar(@RequestBody Calificacion datosCalificaciones){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.calificacionServicio.guardarCalificacion(datosCalificaciones));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id,@RequestBody Calificacion datosCalificaciones){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.calificacionServicio.modificarCalifiacaciones(id, datosCalificaciones));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.calificacionServicio.buscarCalificacionId(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?>buscarTodos(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.calificacionServicio.buscarTodasCalificacion());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
