package com.example.ac2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ac2.entity.Curso;
import com.example.ac2.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController extends BaseController<Curso, Long> {
	@Autowired
	private CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
        super(cursoService);
    }

	@PostMapping("/listarCursos")
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

	@PostMapping("/adicionarCurso")
    public Curso adicionarCurso(@RequestBody Curso curso) {
        return cursoService.salvarCurso(curso);
    }
}
