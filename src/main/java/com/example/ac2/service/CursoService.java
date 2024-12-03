package com.example.ac2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ac2.repository.CursoRepository;
import com.example.ac2.entity.Curso;


@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso salvarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    // outros métodos de serviço podem ser adicionados aqui
}
