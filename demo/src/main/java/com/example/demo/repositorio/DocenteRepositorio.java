package com.example.demo.repositorio;

import com.example.demo.modelos.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocenteRepositorio  extends JpaRepository<Docente,Integer
        > {
}
