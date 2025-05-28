package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
@Entity
@Table(name="Califiacion")
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nota")
    private  Float nota ;
    @Column(name="fechaEvaluacion")
    private LocalDate fechaEvaluacion;

    @ManyToOne
    @JoinColumn(name = "estudiante",referencedColumnName = "id")
    @JsonBackReference(value = "estudianteCalificacion")
    public Estudiante estudiante;

    @ManyToOne()
    @JoinColumn(name="materia",referencedColumnName = "id")
    @JsonBackReference(value = "CalificacionMateria")
    public Materia materia;

    public Calificacion() {
    }

    public Calificacion(Integer id, Float nota, LocalDate fechaEvaluacion) {
        this.id = id;
        this.nota = nota;
        this.fechaEvaluacion = fechaEvaluacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getNota() {
        return nota;
    }

    public void setNota(Float nota) {
        this.nota = nota;
    }

    public LocalDate getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDate fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
