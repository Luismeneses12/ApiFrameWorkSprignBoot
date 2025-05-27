package com.example.demo.servicios;

import com.example.demo.ayudas.mesajeApp;
import com.example.demo.modelos.Usuario;
import com.example.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    public UsuarioRepositorio  usuarioRepositorio;

    public Usuario guardarUsuario (Usuario datosUsuario)throws Exception{
        try {
            return this.usuarioRepositorio.save(datosUsuario);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Usuario modificarUsuario (Integer id,Usuario datosUsuario)throws Exception{
        try{
            Optional<Usuario>buscarUsuario = this.usuarioRepositorio.findById(id);
            if (buscarUsuario.isPresent()){
                buscarUsuario.get().setNombre(datosUsuario.getNombre());
                buscarUsuario.get().setCorreEletronico(datosUsuario.getCorreEletronico());
                buscarUsuario.get().setContrasena(datosUsuario.getContrasena());
                buscarUsuario.get().setTelefono(datosUsuario.getTelefono());
                buscarUsuario.get().setTipoUsuario(datosUsuario.getTipoUsuario());
                return this.usuarioRepositorio.save(buscarUsuario.get());
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_USER.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public Usuario buscarUsuaruioId(Integer id)throws Exception{
        try{
            Optional<Usuario>bucarUsuario = this.usuarioRepositorio.findById(id);
            if (bucarUsuario.isPresent()){
                return bucarUsuario.get();
            }else {
                throw new Exception(mesajeApp.DONT_FOUND_USER.getTexto());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    public List<Usuario>todosUsuario()throws Exception{
        try {
            return  this.usuarioRepositorio.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
