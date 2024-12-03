package com.example.ac2.service.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Estudante;
import com.example.ac2.factory.EstudanteFactory;
import com.example.ac2.repository.EstudanteRepository;
import com.example.ac2.service.EstudanteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

class EstudanteServiceTest {

    @InjectMocks
    private EstudanteService estudanteService;

    @Mock
    private EstudanteRepository estudanteRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void salvarEstudante_deveSalvarENovoEstudante() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteRepository.save(estudanteMock)).thenReturn(estudanteMock);

        Estudante resultado = estudanteService.salvarEstudante(estudanteMock);

        assertNotNull(resultado);
        assertEquals("João", resultado.getNome());
        verify(estudanteRepository, times(1)).save(estudanteMock);
    }

    @Test
    void encontrarPorId_deveRetornarEstudanteCorreto() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteRepository.findById(1L)).thenReturn(Optional.of(estudanteMock));

        Optional<Estudante> resultado = estudanteService.encontrarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("João", resultado.get().getNome());
        verify(estudanteRepository, times(1)).findById(1L);
    }

    @Test
    void emitirVoucherSeApto_deveEmitirVoucherQuandoNotaForSuficiente() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteRepository.findById(1L)).thenReturn(Optional.of(estudanteMock));
        when(estudanteRepository.save(any(Estudante.class))).thenReturn(estudanteMock);

        estudanteService.emitirVoucherSeApto(1L, 8.0);

        verify(estudanteRepository, times(1)).save(estudanteMock);
    }

    @Test
    void emitirVoucherSeApto_naoDeveEmitirVoucherSeNotaInsuficiente() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteRepository.findById(1L)).thenReturn(Optional.of(estudanteMock));

        estudanteService.emitirVoucherSeApto(1L, 6.5);

        verify(estudanteRepository, never()).save(any(Estudante.class));
    }
}
