package com.example.demo.control;

import com.example.demo.modelos.Curso;
import com.example.demo.servicios.CursoServicio;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curso")
public class CursoControl {
    @Autowired
    public CursoServicio cursoServicio;
    @PostMapping()
    public ResponseEntity<?>gurdar(@RequestBody Curso datoscurso){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.cursoServicio.guardarUsuario(datoscurso));
        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>moficar(@PathVariable Integer id,@RequestBody Curso datosCurso){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.cursoServicio.modificaCurso(id,datosCurso));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());}
    }
    @GetMapping("/{id}")
    public ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.cursoServicio.buscarcursoId(id));
        }catch (Exception e)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());

        }
    }
    @GetMapping()
    public ResponseEntity<?>buscarTodo(){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.cursoServicio.buscarTodosCurso());
        }catch (Exception e)
        {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
