package com.example.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.ac2.entity.Estudante;
import com.example.ac2.entity.Voucher;

import java.util.ArrayList;
import java.util.List;

class EstudanteTest {

    @Test
    void estudante_deveSerCriadoComParametrosCorretos() {
        Estudante estudante = new Estudante("Maria");

        assertEquals("Maria", estudante.getNome());
        assertNull(estudante.getVouchers());
    }

    @Test
    void adicionarVoucher_deveAdicionarVoucherNaLista() {
        Estudante estudante = new Estudante("Maria");
        List<Voucher> vouchers = new ArrayList<>();
        estudante.adicionarVoucher(new Voucher("VOUCHER-001"));

        assertNotNull(estudante.getVouchers());
        assertEquals(1, estudante.getVouchers().size());
        assertEquals("VOUCHER-001", estudante.getVouchers().get(0).getCodigo());
    }

    @Test
    void equals_e_hashCode_devemFuncionarCorretamente() {
        Estudante estudante1 = new Estudante("Maria");
        Estudante estudante2 = new Estudante("Maria");

        assertEquals(estudante1, estudante2);
        assertEquals(estudante1.hashCode(), estudante2.hashCode());
    }
}
