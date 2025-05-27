package com.example.demo.control;

import com.example.demo.modelos.Estudiante;
import com.example.demo.servicios.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/estudiante")
public class EstudianteControl {

    @Autowired
    public EstudianteServicio estudianteServicio;

    @PostMapping()
    public ResponseEntity<?>guardar(@RequestBody Estudiante datosEstudiante){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.estudianteServicio.gurdarEstudiante(datosEstudiante));
        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modificar(@PathVariable Integer id, @RequestBody Estudiante datosEstudiante){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.estudianteServicio.modificarEstudinate(id,datosEstudiante));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>BuscarPorId(@PathVariable Integer id){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.estudianteServicio.buscarEstudianteId(id));
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
                    .body(this.estudianteServicio.buscarTodoEstudiante());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
