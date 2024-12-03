package com.example.ac2.controller.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.ac2.controller.CursoController;
import com.example.ac2.entity.Curso;
import com.example.ac2.factory.CursoFactory;
import com.example.ac2.service.CursoService;

import java.util.ArrayList;
import java.util.List;

class CursoControllerTest {
	@Mock
    private CursoService cursoService;

    @InjectMocks
    private CursoController cursoController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarCursos_deveRetornarListaDeCursos() {
        List<Curso> cursosMock = new ArrayList<>();
        cursosMock.add(CursoFactory.build(5L, "Matemática", new ArrayList<>()));
        when(cursoService.listarCursos()).thenReturn(cursosMock);

        List<Curso> resultado = cursoController.listarCursos();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        assertEquals("Matemática", resultado.get(0).getNome());
        verify(cursoService, times(1)).listarCursos();
    }

    @Test
    void adicionarCurso_deveRetornarCursoSalvo() {
        Curso cursoMock = CursoFactory.build(5L, "Matemática", new ArrayList<>());
        when(cursoService.salvarCurso(cursoMock)).thenReturn(cursoMock);

        Curso resultado = cursoController.adicionarCurso(cursoMock);

        assertNotNull(resultado);
        assertEquals("Matemática", resultado.getNome());
        verify(cursoService, times(1)).salvarCurso(cursoMock);
    }
}
