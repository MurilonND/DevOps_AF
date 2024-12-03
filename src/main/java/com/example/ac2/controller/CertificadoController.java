package com.example.ac2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.entity.Certificado;
import com.example.ac2.service.CertificadoService;

@RestController
@RequestMapping("/certificados")
public class CertificadoController {

    private final CertificadoService certificadoService;

    @Autowired
    public CertificadoController(CertificadoService certificadoService) {
        this.certificadoService = certificadoService;
    }

    @PostMapping("/emitir")
    public Certificado emitirCertificado(@RequestParam Long estudanteId) {
        return certificadoService.emitirCertificado(estudanteId);
    }
}