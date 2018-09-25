package br.edu.ifsp.spo.lg2a2.sge.entidades;

import java.util.Collection;

public class Turma {
	
	private Collection<Aluno> alunos;
	private String idCurso;
	private String idTurma;
	
	public Collection<Aluno> getAlunos(){
		return this.alunos;
	}
	
	public String getIdCurso() {
		return this.idCurso;
	}
	
	public String getIdTurma() {
		return this.idTurma;
	}
	
	public void setAlunos(Collection<Aluno> alunos){
		this.alunos = alunos;
	}
	
	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}
	
	public void setIdTurma(String idTurma) {
		this.idTurma = idTurma;
	}
}
