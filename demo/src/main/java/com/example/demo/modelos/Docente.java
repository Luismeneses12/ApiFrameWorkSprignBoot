package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Docente")
public class Docente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private  Integer id;
    @Column(name = "especialidad",nullable = true,length = 30)
    private String especialidad;

    @OneToOne
    @JoinColumn(name="docente",referencedColumnName = "id")
    @JsonBackReference(value = "usuarioDocente")
    private Usuario usuario;

    @OneToMany(mappedBy = "docente",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "DocneteCurso")
    public List<Curso>curso;



    public Docente() {
    }

    public Docente(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
