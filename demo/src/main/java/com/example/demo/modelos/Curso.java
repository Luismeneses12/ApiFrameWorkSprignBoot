package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="nombreCurso")
    private String nombreCusrso;


    @ManyToOne
    @JoinColumn(name ="idDpcente",referencedColumnName = "id")
    @JsonBackReference(value = "docenteCurso")
    public Docente docente;

    @OneToMany(mappedBy = "asistencia ",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cursoAsistencia")
    public List<Asistencia>asistencias;

    @OneToMany(mappedBy = "inscripcion",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "cursoInscripcion")
    public List<Inscripciones>inscipciones;







    public Curso() {
    }

    public Curso(Integer id, String nombreCusrso) {
        this.id = id;
        this.nombreCusrso = nombreCusrso;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCusrso() {
        return nombreCusrso;
    }

    public void setNombreCusrso(String nombreCusrso) {
        this.nombreCusrso = nombreCusrso;
    }
}
