package com.example.ac2.entity.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.ac2.entity.Estudante;
import com.example.ac2.entity.Voucher;

class EstudanteTest {

    @Test
    void estudante_deveSerCriadoComParametrosCorretos() {
        Estudante estudante = new Estudante("Maria");

        assertEquals("Maria", estudante.getNome());
        assertNotNull(estudante.getVouchers());
        assertTrue(estudante.getVouchers().isEmpty()); 
    }

    @Test
    void adicionarVoucher_deveAdicionarVoucherNaLista() {
        Estudante estudante = new Estudante("Maria");
        Voucher voucher = new Voucher("VOUCHER-001");
        estudante.adicionarVoucher(voucher);

        assertNotNull(estudante.getVouchers()); 
        assertEquals(1, estudante.getVouchers().size());
        assertEquals("VOUCHER-001", estudante.getVouchers().get(0).getCodigo()); 
    }
}
