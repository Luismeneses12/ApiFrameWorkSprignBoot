package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Materia")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nombreMateria")
    private  String nombreMateria;



    @OneToMany
    @JoinColumn(name = "materia",referencedColumnName = "id")
    @JsonManagedReference(value = "califiacionesMateria")
    public List<Calificacion>calificacion;



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
