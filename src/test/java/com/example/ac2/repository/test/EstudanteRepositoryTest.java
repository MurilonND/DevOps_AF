package com.example.ac2.repository.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.ac2.entity.Estudante;
import com.example.ac2.repository.EstudanteRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class EstudanteRepositoryTest {

    @Autowired
    private EstudanteRepository estudanteRepository;

    @Test
    void save_devePersistirEstudante() {
        Estudante estudante = new Estudante("Lucas");
        Estudante salvo = estudanteRepository.save(estudante);

        assertNotNull(salvo.getId());
        assertEquals("Lucas", salvo.getNome());
    }

    @Test
    void findById_deveRetornarEstudanteCorreto() {
        Estudante estudante = new Estudante("Lucas");
        Estudante salvo = estudanteRepository.save(estudante);

        Optional<Estudante> encontrado = estudanteRepository.findById(salvo.getId());
        assertTrue(encontrado.isPresent());
        assertEquals(salvo.getId(), encontrado.get().getId());
    }
}
