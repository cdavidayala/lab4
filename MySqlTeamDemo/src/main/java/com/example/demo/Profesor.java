package com.example.demo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Profesor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_Sequence")
	@SequenceGenerator(name = "profesor_Sequence", sequenceName = "PROFESOR_SEQ")
	private Long id;
	
	@Column(name = "documento")
	private	String documento;
	
	@Column(name = "nombre")
	private	String	nombre;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy	= "profesor")
	private	List<Curso> curso;
}
