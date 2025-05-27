package com.example.demo.control;

import com.example.demo.modelos.Docente;
import com.example.demo.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/docente")
public class DocenteControl {
    @Autowired
    public DocenteServicio docenteServicio;

    @PostMapping()
    public ResponseEntity<?> Gurdar(@RequestBody Docente datosDocente){
        try{
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.docenteServicio.gurdarDocente(datosDocente));
        }catch (Exception e) {
                return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage() + "erro");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id,@RequestBody Docente datosDocente){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.docenteServicio.modifiacarDocente(id,datosDocente));
        }catch (Exception e){
            return ResponseEntity.
                    status(HttpStatus.OK)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/{id}")
    public  ResponseEntity<?>buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.docenteServicio.burcarDocenteId(id));
        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?>buscarTodos (){
        try{
            return  ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.docenteServicio.burcarTodosDocente());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }


}
