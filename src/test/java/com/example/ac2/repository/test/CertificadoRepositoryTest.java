package com.example.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;
import com.example.ac2.repository.CertificadoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
class CertificadoRepositoryTest {

    @Autowired
    private CertificadoRepository certificadoRepository;

    @Test
    void save_devePersistirCertificado() {
        Certificado certificado = new Certificado(1L, new Data(LocalDate.now()));
        Certificado salvo = certificadoRepository.save(certificado);

        assertNotNull(salvo.getId());
        assertEquals(certificado.getEstudanteId(), salvo.getEstudanteId());
    }

    @Test
    void findById_deveRetornarCertificadoCorreto() {
        Certificado certificado = new Certificado(1L, new Data(LocalDate.now()));
        Certificado salvo = certificadoRepository.save(certificado);

        Optional<Certificado> encontrado = certificadoRepository.findById(salvo.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(salvo.getId(), encontrado.get().getId());
    }
}
