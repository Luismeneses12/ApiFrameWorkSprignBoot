package com.example.demo.repositorio;

import com.example.demo.modelos.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepositorio extends JpaRepository<Asistencia,Integer> {
}
