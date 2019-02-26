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
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,	generator = "alumno_Sequence")		
	@SequenceGenerator(name	=	"alumno_Sequence",	sequenceName	=	"ALUMNO_SEQ")
	private	Long id;
	
	@Column(name = "documento")
	private	String documento;
	
	@Column(name = "nombre")
	private	String	nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "curso_id", nullable = false)
	private Curso curso;
}
