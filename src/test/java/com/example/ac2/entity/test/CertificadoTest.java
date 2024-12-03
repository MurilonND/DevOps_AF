package com.example.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;

import java.time.LocalDate;

class CertificadoTest {

    @Test
    void certificado_deveSerCriadoComParametrosCorretos() {
        Long estudanteId = 1L;
        Data dataEmissao = new Data(LocalDate.of(2024, 12, 1));
        Certificado certificado = new Certificado(estudanteId, dataEmissao);

        assertEquals(estudanteId, certificado.getEstudanteId());
        assertEquals(dataEmissao, certificado.getDataEmissao());
    }

    @Test
    void equals_e_hashCode_devemFuncionarCorretamente() {
        Long estudanteId = 1L;
        Data dataEmissao = new Data(LocalDate.of(2024, 12, 1));
        Certificado certificado1 = new Certificado(estudanteId, dataEmissao);
        Certificado certificado2 = new Certificado(estudanteId, dataEmissao);

        assertEquals(certificado1, certificado2);
        assertEquals(certificado1.hashCode(), certificado2.hashCode());
    }
}
