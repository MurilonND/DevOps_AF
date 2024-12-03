package com.example.ac2.factory;


import com.example.ac2.entity.Certificado;
import com.example.ac2.entity.Data;

public class CertificadoFactory {
	public static Certificado build(Long id, Long estudanteId, Data dataEmissao) {
        Certificado certificado = new Certificado(estudanteId, dataEmissao);
        certificado.setId(id);
        return certificado;
    }
}
