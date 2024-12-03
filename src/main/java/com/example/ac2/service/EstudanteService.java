package com.example.ac2.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.ac2.entity.Estudante;
import com.example.ac2.entity.Voucher;
import com.example.ac2.repository.EstudanteRepository;

@Service
public class EstudanteService extends BaseService<Estudante, Long> {

    private final EstudanteRepository estudanteRepository;

    public EstudanteService(EstudanteRepository estudanteRepository) {
        this.estudanteRepository = estudanteRepository;
    }

    public Estudante salvarEstudante(Estudante estudante) {
        return estudanteRepository.save(estudante);
    }

    public Optional<Estudante> encontrarPorId(Long id) {
        return estudanteRepository.findById(id);
    }

    public void emitirVoucherSeApto(Long estudanteId, double nota) {
        Optional<Estudante> estudanteOpt = estudanteRepository.findById(estudanteId);
        if (estudanteOpt.isPresent() && nota >= 7) {
            Estudante estudante = estudanteOpt.get();
            Voucher voucher = new Voucher("VOUCHER-" + estudante.getId() + "-" + System.currentTimeMillis());
            estudante.adicionarVoucher(voucher);
            estudanteRepository.save(estudante);
        }
    }
}