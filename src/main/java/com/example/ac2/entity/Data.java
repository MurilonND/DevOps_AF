package com.example.ac2.entity;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Data {

    private LocalDate data;

    // Construtor padrão necessário para o JPA
    protected Data() {}

    public Data(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("Data não pode ser nula.");
        }
        this.data = data;
    }

    public LocalDate getData() {
        return data;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Data dataObj = (Data) o;
        return Objects.equals(data, dataObj.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
