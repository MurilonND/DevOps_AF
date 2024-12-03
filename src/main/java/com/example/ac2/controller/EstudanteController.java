package com.example.ac2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.entity.Estudante;
import com.example.ac2.service.EstudanteService;

@CrossOrigin
@RestController
@RequestMapping("/estudantes")
public class EstudanteController extends BaseController<Estudante, Long> {
	@Autowired
	private EstudanteService estudanteService;
	
	public EstudanteController(EstudanteService estudanteService) {
        super(estudanteService);
    }

    @PostMapping
    public Estudante adicionarEstudante(@RequestBody Estudante estudante) {
        return estudanteService.salvarEstudante(estudante);
    }

    @PostMapping("/{id}/voucher")
    public String emitirVoucherSeApto(@PathVariable Long id, @RequestParam double nota) {
        estudanteService.emitirVoucherSeApto(id, nota);
        return "Verificação de voucher realizada com sucesso.";
    }

    @GetMapping("/{id}")
    public Optional<Estudante> encontrarEstudante(@PathVariable Long id) {
        return estudanteService.encontrarPorId(id);
    }
}