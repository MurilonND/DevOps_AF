package com.example.ac2.factory;

import java.util.ArrayList;
import java.util.List;

import com.example.ac2.entity.Curso;
import com.example.ac2.entity.Nota;

public class CursoFactory {
    public static Curso build(Long id, String nome, List<Nota> notas) {
        Curso curso = new Curso(nome, notas != null ? notas : new ArrayList<>());
        curso.setId(id);
        return curso;
    }
}
