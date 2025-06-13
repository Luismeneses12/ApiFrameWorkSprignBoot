package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="Inscripsiones")
public class Inscripciones {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="fechaInscripcion")
    private LocalDate fechaInscripcion;

    @ManyToOne
    @JoinColumn(name = "asistencia",referencedColumnName = "id")
    @JsonBackReference(value = "cursoInscripcion")
    public Curso curso;

    @ManyToOne
    @JoinColumn(name="Estudiante",referencedColumnName = "id")
    @JsonBackReference(value = "estudianteInscripcion")
    public Estudiante estudiante;



    public Inscripciones() {
    }

    public Inscripciones(Integer id, LocalDate fechaInscripcion) {
        this.id = id;
        this.fechaInscripcion = fechaInscripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
}
