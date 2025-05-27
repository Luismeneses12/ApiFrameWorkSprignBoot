package com.example.demo.repositorio;

import com.example.demo.modelos.Inscripciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscripcionRepositorio extends JpaRepository<Inscripciones,Integer> {
}
