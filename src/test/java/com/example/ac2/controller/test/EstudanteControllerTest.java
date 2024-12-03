package com.example.ac2.controller.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.controller.EstudanteController;
import com.example.ac2.entity.Estudante;
import com.example.ac2.factory.EstudanteFactory;
import com.example.ac2.service.EstudanteService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

class EstudanteControllerTest {

	@MockBean
    private EstudanteController estudanteController;

    @Mock
    private EstudanteService estudanteService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        estudanteController = new EstudanteController(estudanteService);
    }


    @Test
    void adicionarEstudante_deveRetornarEstudanteSalvo() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteService.salvarEstudante(estudanteMock)).thenReturn(estudanteMock);

        Estudante resultado = estudanteController.adicionarEstudante(estudanteMock);

        assertNotNull(resultado);
        assertEquals("João", resultado.getNome());
        verify(estudanteService, times(1)).salvarEstudante(estudanteMock);
    }

    @Test
    void emitirVoucherSeApto_deveChamarServico() {
        doNothing().when(estudanteService).emitirVoucherSeApto(1L, 8.5);

        String resultado = estudanteController.emitirVoucherSeApto(1L, 8.5);

        assertEquals("Verificação de voucher realizada com sucesso.", resultado);
        verify(estudanteService, times(1)).emitirVoucherSeApto(1L, 8.5);
    }

    @Test
    void encontrarEstudante_deveRetornarEstudante() {
        Estudante estudanteMock = EstudanteFactory.build(2L, "João", null);
        when(estudanteService.encontrarPorId(1L)).thenReturn(Optional.of(estudanteMock));

        Optional<Estudante> resultado = estudanteController.encontrarEstudante(1L);

        assertTrue(resultado.isPresent());
        assertEquals("João", resultado.get().getNome());
        verify(estudanteService, times(1)).encontrarPorId(1L);
    }
}
