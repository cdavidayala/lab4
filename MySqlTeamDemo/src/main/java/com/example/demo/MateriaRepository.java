package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {
	List<Materia> findByCursoId(long cursoId);
	List<Materia> findByProfesorId(long profesorId);
}
