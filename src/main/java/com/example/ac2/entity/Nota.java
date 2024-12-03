package com.example.ac2.entity;

import jakarta.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Nota {

    private double valor;

    // Construtor padrão necessário para o JPA
    protected Nota() {}

    public Nota(double valor) {
        if (valor < 0 || valor > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nota nota = (Nota) o;
        return Double.compare(nota.valor, valor) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}
