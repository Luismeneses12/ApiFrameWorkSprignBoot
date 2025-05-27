package com.example.demo.control;

import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioContol {
    @Autowired
    public UsuarioServicio usuarioServicio;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody Usuario datosUsaurio){
        try {
            return  ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.usuarioServicio.guardarUsuario(datosUsaurio));
        } catch (Exception e) {
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?>modificar(@PathVariable Integer id,@RequestBody Usuario datos) throws Exception {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.modificarUsuario(id, datos));
        } catch (Exception e){
                return  ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(e.getMessage());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.buscarPorId(id));
        }
        catch (Exception e){
            return  ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
    @GetMapping()
    public ResponseEntity<?> buscarTodosUsuario(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.usuarioServicio.todosUsuario());
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
