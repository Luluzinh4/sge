package br.edu.ifsp.spo.lg2a2.sge.entidades;

import java.util.Collection;

public class Curso {

	private Collection<Turma> turmas;
	private String codigoCurso;
	
	public Collection<Turma> getTurmas() {
		return this.turmas;
	}
	
	public String getCodigoCurso() {
		return this.codigoCurso;
	}

}
