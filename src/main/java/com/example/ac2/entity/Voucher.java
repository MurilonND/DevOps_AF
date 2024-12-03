package com.example.ac2.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;


@Embeddable
public class Voucher {

    private String codigo;

    // Construtor padrão necessário para o JPA
    protected Voucher() {}

    public Voucher(String codigo) {
        if (codigo == null || codigo.isEmpty()) {
            throw new IllegalArgumentException("Código do voucher não pode ser vazio.");
        }
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return Objects.equals(codigo, voucher.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}