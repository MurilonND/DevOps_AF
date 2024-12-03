package com.example.ac2.controller.test;

import static org.mockito.Mockito.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.controller.CertificadoController;
import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;
import com.example.ac2.factory.CertificadoFactory;
import com.example.ac2.service.CertificadoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

class CertificadoControllerTest {

	@MockBean
    private CertificadoController certificadoController;

    @Mock
    private CertificadoService certificadoService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        certificadoController = new CertificadoController(certificadoService);
    }


    @Test
    void emitirCertificado_deveRetornarCertificado() {
        Long estudanteId = 4L;
        Data dataEmissao = new Data(LocalDate.of(2024, 12, 1));
        Certificado certificadoMock = CertificadoFactory.build(15L, estudanteId, dataEmissao);
        when(certificadoService.emitirCertificado(estudanteId)).thenReturn(certificadoMock);

        Certificado resultado = certificadoController.emitirCertificado(estudanteId);

        assertNotNull(resultado);
        assertEquals(estudanteId, resultado.getEstudanteId());
        verify(certificadoService, times(1)).emitirCertificado(estudanteId);
    }
}
