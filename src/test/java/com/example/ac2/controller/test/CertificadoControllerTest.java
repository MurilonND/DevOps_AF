package com.example.ac2.controller.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.controller.CertificadoController;
import com.example.ac2.entity.Certificado;
import com.example.ac2.service.CertificadoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class CertificadoControllerTest {

    @InjectMocks
    private CertificadoController certificadoController;

    @Mock
    private CertificadoService certificadoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void emitirCertificado_deveRetornarCertificado() {
        Long estudanteId = 1L;
        Certificado certificadoMock = new Certificado(estudanteId, null);
        when(certificadoService.emitirCertificado(estudanteId)).thenReturn(certificadoMock);

        Certificado resultado = certificadoController.emitirCertificado(estudanteId);

        assertNotNull(resultado);
        assertEquals(estudanteId, resultado.getEstudanteId());
        verify(certificadoService, times(1)).emitirCertificado(estudanteId);
    }
}
