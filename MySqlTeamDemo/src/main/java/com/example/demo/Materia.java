package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materia_Sequence")
	@SequenceGenerator(name = "materia_Sequence", sequenceName = "MATERIA_SEQ")
	private Long id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "otrocampo")
	private String otrocampo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "profesor_id", nullable = false)
	private Profesor profesor;
}
