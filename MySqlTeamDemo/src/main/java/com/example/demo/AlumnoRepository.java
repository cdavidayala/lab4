package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	List<Alumno> findByCursoId(long cursoId);
}
