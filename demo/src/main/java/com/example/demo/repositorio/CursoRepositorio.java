package com.example.demo.repositorio;

import com.example.demo.modelos.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso,Integer> {
}
