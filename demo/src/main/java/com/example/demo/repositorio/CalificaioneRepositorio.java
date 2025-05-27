package com.example.demo.repositorio;

import com.example.demo.modelos.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalificaioneRepositorio extends JpaRepository<Calificacion,Integer> {
}
