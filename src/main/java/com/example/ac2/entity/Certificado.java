package com.example.ac2.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_certificados")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long estudanteId;

    @Embedded
    private Data dataEmissao;

    // Construtor padrão necessário para o JPA
    protected Certificado() {}

    public Certificado(Long estudanteId, Data dataEmissao) {
        this.estudanteId = estudanteId;
        this.dataEmissao = dataEmissao;
    }

	public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
    	this.id = id;
	}

    public Long getEstudanteId() {
        return estudanteId;
    }

    public Data getDataEmissao() {
        return dataEmissao;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificado certificado = (Certificado) o;
        return Objects.equals(id, certificado.id) &&
                Objects.equals(estudanteId, certificado.estudanteId) &&
                Objects.equals(dataEmissao, certificado.dataEmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estudanteId, dataEmissao);
    }
}
