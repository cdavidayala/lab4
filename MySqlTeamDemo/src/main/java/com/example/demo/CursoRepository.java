package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long>{
	List<Curso> findByProfesorId(long profesorId);
}
