package com.example.demo;

import java.util.List;

public interface ColegioService {
	
	public List<String> getAllAlumnosXCurso(long cursoId);
	public void addAlumnosToCurso(String documento, String nombre, Long cursoId);
	
	public List<String> getAllMateriasXCurso(long cursoId);
	public void addMateriasToCurso(String nombre, String otrocampo, Long cursoId, Long ProfesorId);
	
	public List<String> getAllCursosXProfesor(long profesorId);
	public void addCursoToProfesor(String nombre, String otrocampo, Long profesorId);
}
