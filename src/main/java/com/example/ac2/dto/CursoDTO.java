package com.example.ac2.dto;

import java.util.List;

public class CursoDTO {
    private Long id;
    private String nome;
    private List<Double> notas; // Apenas as notas, sem informações de entidade

    public CursoDTO() {}

    public CursoDTO(Long id, String nome, List<Double> notas) {
        this.id = id;
        this.nome = nome;
        this.notas = notas;
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

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        this.notas = notas;
    }
}
