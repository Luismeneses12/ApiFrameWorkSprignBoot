package com.example.demo.modelos;

import com.example.demo.ayudas.TiposUsuario;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
@Table(name="Usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="nombre")
    private String nombre;
    @Column(name = "correoElectronico")
    private String correElectronico;
    @Column(name="contrasena")
    private String contrasena;
    @Column(name="telefono")
    private String telefono;
    @Enumerated(EnumType.STRING)
    @Column(name = "tipoUsuario")
    private TiposUsuario tipoUsuario;

    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usuarioDocente")
    private Docente docente;
    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "usuarioEstudiante")
    private Estudiante estudiante;



    public Usuario() {
    }
    public Usuario(String nombre, Integer id, String correElectronico, String contrasena, String telefono, TiposUsuario tipoUsuario) {
        this.nombre = nombre;
        this.id = id;
        this.correElectronico = correElectronico;
        this.contrasena = contrasena;
        this.telefono = telefono;
        this.tipoUsuario = tipoUsuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreEletronico() {
        return correElectronico;
    }

    public void setCorreEletronico(String correEletronico) {
        this.correElectronico = correEletronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public TiposUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TiposUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
