package com.example.ac2.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "notas", joinColumns = @JoinColumn(name = "curso_id"))
    private List<Nota> notas;

    // Construtor padrão necessário para o JPA
    protected Curso() {}

    public Curso(String nome, List<Nota> notas) {
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void adicionarNota(Nota nota) {
        this.notas.add(nota);
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(id, curso.id) && Objects.equals(nome, curso.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
