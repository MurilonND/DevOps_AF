package com.example.ac2.service.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Curso;
import com.example.ac2.repository.CursoRepository;
import com.example.ac2.service.CursoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

class CursoServiceTest {

    @InjectMocks
    private CursoService cursoService;

    @Mock
    private CursoRepository cursoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCursos_deveRetornarTodosOsCursos() {
        List<Curso> cursosMock = new ArrayList<>();
        cursosMock.add(new Curso("Matemática", new ArrayList<>()));
        when(cursoRepository.findAll()).thenReturn(cursosMock);

        List<Curso> resultado = cursoService.listarCursos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Matemática", resultado.get(0).getNome());
        verify(cursoRepository, times(1)).findAll();
    }

    @Test
    void salvarCurso_deveSalvarENovoCurso() {
        Curso cursoMock = new Curso("Matemática", new ArrayList<>());
        when(cursoRepository.save(cursoMock)).thenReturn(cursoMock);

        Curso resultado = cursoService.salvarCurso(cursoMock);

        assertNotNull(resultado);
        assertEquals("Matemática", resultado.getNome());
        verify(cursoRepository, times(1)).save(cursoMock);
    }
}
