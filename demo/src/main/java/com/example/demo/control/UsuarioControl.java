package com.example.demo.control;


import com.example.demo.modelos.Usuario;
import com.example.demo.servicios.UsuarioServicio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/usuarios")
@Tag(name = "metodo principar para la tabla padre de todos los ususario ",
        description = "esta capa de modleos es la relacion de usurio para ingresar  todos ls tiposde usuario ")
public class UsuarioControl {
    @Autowired
    public UsuarioServicio usuarioServicio;

    @PostMapping("/usuario")
    @Operation(summary = "metodo para guardar ",
    description = "este metdo emplea  el request body par aingredar la informacion de los usuario ")
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
    @Operation(summary = "metodo para modificar  los datos por id y atributso ",
    description = "este metodo mofificay cambia valores a alos atributos")
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
    @GetMapping("/{id}")
    @Operation(summary = "metodo get para buscar por id",
    description = "metodo de busca por el valor id que es un a entero  ")
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
    @Operation(summary = "buscar todos los objectodentro de  la tabla ",
    description = "este metodo muestra todos los objecto ingresados ")
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
