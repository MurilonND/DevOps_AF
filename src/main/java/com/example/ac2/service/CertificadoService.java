package com.example.ac2.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;
import com.example.ac2.repository.CertificadoRepository;

@Service
public class CertificadoService extends BaseService<Certificado, Long> {

    private final CertificadoRepository certificadoRepository;

    public CertificadoService(CertificadoRepository certificadoRepository) {
        this.certificadoRepository = certificadoRepository;
    }

    public Certificado emitirCertificado(Long estudanteId) {
    	Certificado certificado = new Certificado(estudanteId, new Data(LocalDate.now()));
        return certificadoRepository.save(certificado);
    }
}