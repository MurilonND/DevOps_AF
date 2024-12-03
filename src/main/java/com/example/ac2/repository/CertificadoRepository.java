package com.example.ac2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ac2.entity.Certificado;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
    // métodos de consulta personalizados podem ser adicionados aqui
}