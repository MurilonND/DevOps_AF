package com.example.ac2.factory;

import java.util.List;

import com.example.ac2.entity.Estudante;
import com.example.ac2.entity.Voucher;

public class EstudanteFactory {
    public static Estudante build(Long id, String nome, List<Voucher> vouchers) {
        Estudante estudante = new Estudante(nome);
        estudante.setId(id);
        if (vouchers != null) {
            estudante.getVouchers().addAll(vouchers);
        }
        return estudante;
    }
}
