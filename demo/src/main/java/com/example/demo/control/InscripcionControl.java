package com.example.demo.control;

import com.example.demo.modelos.Inscripciones;
import com.example.demo.servicios.InscripcionServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inscripcion")
public class InscripcionControl {
    @Autowired
    public InscripcionServicio inscripcionServicio;

    @PostMapping()
    public ResponseEntity<?> guardar(@RequestBody Inscripciones datosInscripcion){
        try{ return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.inscripcionServicio.guardaInscripcion(datosInscripcion));

        }catch(Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Inscripciones datosInscripcion){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.inscripcionServicio.BuscarInscripcionId(id,datosInscripcion));
        } catch (Exception e) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId (@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.inscripcionServicio.buscarIncripcionId(id));
        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?>buscarTodoInscripcion(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.inscripcionServicio.buscarTodoIncripcion());
        }catch (Exception e){
          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body(e.getMessage());
        }

    }
}
