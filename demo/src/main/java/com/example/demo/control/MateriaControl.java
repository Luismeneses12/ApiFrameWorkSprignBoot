package com.example.demo.control;

import com.example.demo.modelos.Materia;
import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.MateriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/materia")
public class MateriaControl {

    @Autowired
    public MateriaServicio materiaServicio;

    @PostMapping()
    public ResponseEntity<?>guardarMateria(@RequestBody Materia datosMateria){
        try {
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.materiaServicio.guardaMateria(datosMateria));

        }catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

}
