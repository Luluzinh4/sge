package br.edu.ifsp.spo.lg2a2.sge;

import java.util.Collection;

import br.edu.ifsp.spo.lg2a2.sge.entidades.Aluno;
import br.edu.ifsp.spo.lg2a2.sge.entidades.Curso;
import br.edu.ifsp.spo.lg2a2.sge.entidades.SituacaoMatricula;
import br.edu.ifsp.spo.lg2a2.sge.repositories.AlunosRepository;
import br.edu.ifsp.spo.lg2a2.sge.repositories.CursosRepository;
import br.edu.ifsp.spo.lg2a2.sge.vo.ComprovanteMatricula;
import br.edu.ifsp.spo.lg2a2.sge.vo.DadosAluno;

public class ProcessoDeMatricula {
	
	private Curso curso;
	private CursosRepository CursosRepository;
	SituacaoMatricula resultado = null;
	
	
	public ProcessoDeMatricula(Curso curso) {
		this.curso = curso;
		CursosRepository = new CursosRepository();
	}

	public SituacaoMatricula verificarExistenciaAluno(String cpf) {
		for(Aluno aluno : CursosRepository.alunos) {
			if(aluno.getCpf().equals(cpf)) {
				return true;
			}/*else {
				return false;
			}*/
		}
	}
	
	public ComprovanteMatricula processarMatricula(DadosAluno dados) {
		return null;
	}
	
	private String gerarProntuario() {
		return resultado;
	}
	
}
