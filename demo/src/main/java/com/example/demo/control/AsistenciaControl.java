package com.example.demo.control;

import com.example.demo.modelos.Asistencia;
import com.example.demo.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaControl {
    @Autowired
    public AsistenciaServicio asistenciaServicio;

    @PostMapping()
    public ResponseEntity<?>guardar(@RequestBody Asistencia datosAsistencia){
        try{
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.asistenciaServicio.gurdarAsistencia(datosAsistencia));

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id, @RequestBody Asistencia datosAsistencia){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.asistenciaServicio.modificarAsitencia(id, datosAsistencia));
        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.asistenciaServicio.buscarAsistenciaId(id));
        } catch (Exception e) {
            return ResponseEntity.
                    status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?>buscarTodos(){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.asistenciaServicio.buscarTodasAsistencia());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
