package br.edu.ifsp.spo.lg2a2.sge;

import java.util.Collection;
import java.util.Random;

import br.edu.ifsp.spo.lg2a2.sge.entidades.Aluno;
import br.edu.ifsp.spo.lg2a2.sge.entidades.Curso;
import br.edu.ifsp.spo.lg2a2.sge.entidades.Turma;
import br.edu.ifsp.spo.lg2a2.sge.entidades.SituacaoMatricula;
import br.edu.ifsp.spo.lg2a2.sge.repositories.AlunosRepository;
import br.edu.ifsp.spo.lg2a2.sge.repositories.CursosRepository;
import br.edu.ifsp.spo.lg2a2.sge.vo.ComprovanteMatricula;
import br.edu.ifsp.spo.lg2a2.sge.vo.DadosAluno;

public class ProcessoDeMatricula {
	
	private Curso curso;
	//private Aluno aluno;
	private CursosRepository CursosRepository;
	private AlunosRepository AlunosRepository;
	SituacaoMatricula resultado = null;
	
	Random gerador = new Random();
	
	public ProcessoDeMatricula(Curso curso) {
		this.curso = curso;
		CursosRepository = new CursosRepository();
		AlunosRepository = new AlunosRepository();
	}

	public SituacaoMatricula verificarExistenciaAluno(String cpf) {
		for(Aluno aluno : CursosRepository.alunos) {
			if(aluno.getCpf().equals(cpf)) {
				if(CursosRepository.existeAlunoNoCurso(cpf)) {
					resultado = SituacaoMatricula.CadastradoNoCurso;
				} else {
					resultado = SituacaoMatricula.Cadastrado;
				}
			}else {
				resultado = SituacaoMatricula.Novo;
			}
		}
		return resultado;
	}
	
	public ComprovanteMatricula processarMatricula(DadosAluno dados) {
		Aluno aluno = new Aluno(gerarProntuario(), dados.getCpf(), dados.getNome(), dados.getEmail());
		Collection<Turma> codigosTurmas = CursosRepository.buscarTurmas(curso.getCodigoCurso());
		Turma turma = CursosRepository.buscarTurma(codigosTurmas);
		
		ComprovanteMatricula comprovante = new ComprovanteMatricula(aluno, turma);
		
		return comprovante;
	}
	
	private String gerarProntuario() {
		int numero = 0;
		String prontuario;
		if (resultado == SituacaoMatricula.Novo || resultado == SituacaoMatricula.CadastradoNoCurso) {
			do {
				numero = gerador.nextInt();
			}while (numero < 10);
		} else {
			System.out.println("O Aluno j� possui prontu�rio gerado para o curso.\n");
		}
		prontuario = String.valueOf(numero);
		
		return prontuario;
	}
}
