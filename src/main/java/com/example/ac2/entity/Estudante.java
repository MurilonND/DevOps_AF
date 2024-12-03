package com.example.ac2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estudantes")
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ElementCollection
    @CollectionTable(name = "vouchers", joinColumns = @JoinColumn(name = "estudante_id"))
    private List<Voucher> vouchers = new ArrayList<>(); // Inicialização aqui

    // Construtor padrão necessário para o JPA
    protected Estudante() {}

    public Estudante(String nome) {
        this.nome = nome;
        this.vouchers = new ArrayList<>(); // Inicialização também no construtor
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Voucher> getVouchers() {
        return vouchers;
    }

    public void adicionarVoucher(Voucher voucher) {
        this.vouchers.add(voucher);
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudante estudante = (Estudante) o;
        return Objects.equals(id, estudante.id) && Objects.equals(nome, estudante.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
