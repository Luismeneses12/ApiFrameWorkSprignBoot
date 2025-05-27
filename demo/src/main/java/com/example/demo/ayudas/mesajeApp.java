package com.example.demo.ayudas;

public enum mesajeApp {
    DONT_FOUND_STUDENT("El estudiante que buscas no se encuentra en BD"),
    DONT_FOUND_COURSE("El curso que buscas no se encuentra en la BD"),
    DONT_FOUND_INSCRIPTION("La inscripcion que buscas no se encuentra en la BD"),
    DONT_FOUND_USER("El usuario que buscas no se encuentra en la BD"),
    DONT_FOUND_TEACHER("El docente que buscas no se encuentra en BD"),
    DONT_FOUND_GRADE("Las notas que buscas no se encuentran en la BD"),
    DONT_FOUND_ATTENDANCE("La asistencia que busca no se encuentra en la BD"),
    DONT_FOUND_SUBJECT("La materia que busca no se encuentra en la BD");

    private String texto;

    mesajeApp(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }
}
