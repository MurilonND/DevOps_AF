package com.example.ac2.service.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;
import com.example.ac2.factory.CertificadoFactory;
import com.example.ac2.repository.CertificadoRepository;
import com.example.ac2.service.CertificadoService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

class CertificadoServiceTest {

    @InjectMocks
    private CertificadoService certificadoService;

    @Mock
    private CertificadoRepository certificadoRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void emitirCertificado_deveSalvarENovoCertificado() {
    	Long estudanteId = 4L;
        Data dataEmissao = new Data(LocalDate.of(2024, 12, 1));
        Certificado certificadoMock = CertificadoFactory.build(15L, estudanteId, dataEmissao);
        when(certificadoRepository.save(any(Certificado.class))).thenReturn(certificadoMock);

        Certificado resultado = certificadoService.emitirCertificado(estudanteId);

        assertNotNull(resultado);
        assertEquals(estudanteId, resultado.getEstudanteId());
        verify(certificadoRepository, times(1)).save(any(Certificado.class));
    }
}
