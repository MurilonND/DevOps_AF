package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.entity.Estudante;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
    // métodos de consulta personalizados podem ser adicionados aqui
}