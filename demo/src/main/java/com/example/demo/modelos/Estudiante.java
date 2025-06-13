package com.example.demo.modelos;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name="Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "grado")
    private Integer grado;
    @Column(name="fechaNacimiento")
    private LocalDate fechaNaciemnto;
    @Column(name="direccion")
    private String direccion;

    @OneToOne
    @JoinColumn(name="fkId",referencedColumnName = "id")
    @JsonBackReference(value = "usuarioEstudiante")
    private Usuario usuario;

    @OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "EstudianteAsistencia")
    public List<Asistencia>asistencias;


    @OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "estudianteCalificaciones")
    public List<Calificacion>calificacion;


    @OneToMany(mappedBy = "estudiante",cascade = CascadeType.ALL)
    @JsonManagedReference(value = "estudianteInscripcion")
    public List<Inscripciones>inscipciones;

    public Estudiante() {
    }

    public Estudiante(Integer id, Integer grado, LocalDate fechaNaciemnto, String direccion) {
        this.id = id;
        this.grado = grado;
        this.fechaNaciemnto = fechaNaciemnto;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGrado() {
        return grado;
    }

    public void setGrado(Integer grado) {
        this.grado = grado;
    }

    public LocalDate getFechaNaciemnto() {
        return fechaNaciemnto;
    }

    public void setFechaNaciemnto(LocalDate fechaNaciemnto) {
        this.fechaNaciemnto = fechaNaciemnto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
