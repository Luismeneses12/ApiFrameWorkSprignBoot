package com.example.demo.modelos;

import com.example.demo.ayudas.Estado;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;
@Table(name="Asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="fechaAsistencia")
    private LocalDate fechaAsistencia;
    @Column(name="estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="idCurso",referencedColumnName = "id")
    @JsonBackReference(value = "cursoAsistencia")
    public Curso curso;

    @ManyToOne
    @JoinColumn(name = "asistencia",referencedColumnName = "id")
    @JsonBackReference(value = "estudianteAsistencia")
    public Estudiante estudiante;




    public Asistencia() {
    }

    public Asistencia(Integer id, LocalDate fechaAsistencia, Estado estado) {
        this.id = id;
        this.fechaAsistencia = fechaAsistencia;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(LocalDate fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
