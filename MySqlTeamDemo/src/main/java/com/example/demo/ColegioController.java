package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(path = "/colegioController")
public class ColegioController {
	@Autowired
	private ColegioService colegioService;
	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@PostMapping("/profesor")
	ResponseEntity<?> profesor(@RequestBody Profesor profesor, UriComponentsBuilder ucBuilder) {
		profesorRepository.save(profesor);
		HttpHeaders headers = new HttpHeaders();

		headers.setLocation(
				ucBuilder.path("/colegioController/profesor/{id}").buildAndExpand(profesor.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	@GetMapping(path = "/alumnos/{id}")
	public @ResponseBody Iterable<String> getAllAlumnos(@PathVariable("id") Long cursoId) {
		return colegioService.getAllAlumnosXCurso(cursoId);
	}
	
	@GetMapping(path = "/materias/{id}")
	public @ResponseBody Iterable<String> getAllMaterias(@PathVariable("id") Long cursoId) {
		return colegioService.getAllMateriasXCurso(cursoId);
	}
	
	@GetMapping(path = "/cursos/{id}")
	public @ResponseBody Iterable<String> getAllCursos(@PathVariable("id") Long profesorId) {
		return colegioService.getAllCursosXProfesor(profesorId);
	}
}
