package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Table(name="Materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nombreMateria")
    private  String nombreMateria;

    @ManyToMany
    @JoinColumn(name = "calificaciones",referencedColumnName = "id")
    @JsonBackReference(value = "califiacionesMateria")
    public Calificacion calificacion;



    public Materia() {
    }

    public Materia(Integer id, String nombreMateria) {
        this.id = id;
        this.nombreMateria = nombreMateria;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
}
