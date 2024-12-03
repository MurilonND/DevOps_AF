package com.example.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Curso;
import com.example.ac2.entity.Nota;
import com.example.ac2.factory.CursoFactory;
import com.example.ac2.repository.CursoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
class CursoRepositoryTest {

    @Autowired
    private CursoRepository cursoRepository;

    @Test
    void save_devePersistirCurso() {
        List<Nota> notas = new ArrayList<>();
        Curso curso = CursoFactory.build(5L,"Matemática", notas);
        Curso salvo = cursoRepository.save(curso);

        assertNotNull(salvo.getId());
        assertEquals("Matemática", salvo.getNome());
    }

    @Test
    void findById_deveRetornarCursoCorreto() {
        List<Nota> notas = new ArrayList<>();
        Curso curso = CursoFactory.build(5L,"Matemática", notas);
        Curso salvo = cursoRepository.save(curso);

        Optional<Curso> encontrado = cursoRepository.findById(salvo.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(salvo.getId(), encontrado.get().getId());
    }
}
