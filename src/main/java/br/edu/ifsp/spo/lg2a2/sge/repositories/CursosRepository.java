package br.edu.ifsp.spo.lg2a2.sge.repositories;

import java.util.ArrayList;
import java.util.Collection;

import br.edu.ifsp.spo.lg2a2.sge.entidades.Aluno;
import br.edu.ifsp.spo.lg2a2.sge.entidades.Curso;
import br.edu.ifsp.spo.lg2a2.sge.entidades.Turma;

public class CursosRepository {
	
	private static Collection<Aluno> alunos = new ArrayList<Aluno>();
	//private static Collection<Turma> turmas = new ArrayList<Turma>();
	private static Collection<Curso> cursos = new ArrayList<Curso>();
	
	public CursosRepository(Collection<Turma> turmas) {
		CursosRepository.alunos.addAll(alunos);
	}

	public Curso buscarPorCodigo(String codigo) {
		for(Curso curso : CursosRepository.cursos)
		{
			if(curso.getCodigoCurso().equals(codigo))
			{
				return curso;
			}/*else {
				return null;
			}*/
		}
		return null;
	}
	
	/*public Collection<Turma> buscarTurmas(String codigoCurso){
		return null;
	}
	
	public Collection<Aluno> buscarAlunos(String codigoCurso){
		return null;
	}*/
	
	public boolean existeAlunoNoCurso(String cpf) {
		for(Aluno aluno : CursosRepository.alunos) {
			if(aluno.getCpf().equals(cpf)) {
				return true;
			}/*else {
				return false;
			}*/
		}
		return false;
	}
	
	public void adicionarAluno(Aluno aluno) {
		CursosRepository.alunos.add(aluno);
	}
	
}
