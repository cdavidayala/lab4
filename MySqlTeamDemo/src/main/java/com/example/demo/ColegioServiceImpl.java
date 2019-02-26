package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	private AlumnoRepository alumnoRepository;
	@Autowired
	private CursoRepository cursoRepository;
	@Autowired
	private MateriaRepository materiaRepository;
	@Autowired
	private ProfesorRepository profesorRepository;

	@Override
	public List<String> getAllAlumnosXCurso(long cursoId) {
		List<String> result = new ArrayList<String>();
		List<Alumno> alumnos = alumnoRepository.findByCursoId(cursoId);
		for (Alumno alumno : alumnos) {
			result.add(alumno.getNombre());
		}
		return result;
	}

	@Override
	public void addAlumnosToCurso(String documento, String nombre, Long cursoId) {
		Curso curso = cursoRepository.findById(cursoId).get();
		Alumno newAlumno = new Alumno();
		newAlumno.setDocumento(documento);
		newAlumno.setNombre(nombre);
		alumnoRepository.save(newAlumno);
	}

	@Override
	public List<String> getAllMateriasXCurso(long cursoId) {
		List<String> result = new ArrayList<String>();
		List<Materia> materias = materiaRepository.findByCursoId(cursoId);
		for (Materia materia : materias) {
			result.add(materia.getNombre());
		}
		return result;
	}

	@Override
	public void addMateriasToCurso(String nombre, String otrocampo, Long cursoId, Long profesorId) {
		Curso curso = cursoRepository.findById(cursoId).get();
		Profesor profesor = profesorRepository.findById(profesorId).get();
		Materia newMateria = new Materia();
		newMateria.setNombre(nombre);
		newMateria.setOtrocampo(otrocampo);
		materiaRepository.save(newMateria);
	}

	@Override
	public List<String> getAllCursosXProfesor(long profesorId) {
		List<String> result = new ArrayList<String>();
		List<Curso> cursos = cursoRepository.findByProfesorId(profesorId);
		for (Curso curso : cursos) {
			result.add(curso.getNombre());
		}
		return result;
	}

	@Override
	public void addCursoToProfesor(String nombre, String otrocampo, Long profesorId) {
		Profesor profesor = profesorRepository.findById(profesorId).get();
		Curso newCurso = new Curso();
		newCurso.setNombre(nombre);
		newCurso.setOtrocampo(otrocampo);
		cursoRepository.save(newCurso);
	}
}
