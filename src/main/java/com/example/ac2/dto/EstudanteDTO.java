package com.example.ac2.dto;

import java.util.List;

public class EstudanteDTO {
    private Long id;
    private String nome;
    private List<String> vouchers; // Apenas os códigos dos vouchers

    public EstudanteDTO() {}

    public EstudanteDTO(Long id, String nome, List<String> vouchers) {
        this.id = id;
        this.nome = nome;
        this.vouchers = vouchers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getVouchers() {
        return vouchers;
    }

    public void setVouchers(List<String> vouchers) {
        this.vouchers = vouchers;
    }
}
