package com.example.ac2.dto;

import java.time.LocalDate;

public class CertificadoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataEmissao;

    public CertificadoDTO() {}

    public CertificadoDTO(Long id, String descricao, LocalDate dataEmissao) {
        this.id = id;
        this.descricao = descricao;
        this.dataEmissao = dataEmissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
}

