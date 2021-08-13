package br.com.escola;

import br.com.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDto;
import br.com.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.escola.gamificacao.aplicacao.GeraSeloAlunoNovato;
import br.com.escola.gamificacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.escola.shared.dominio.CPF;
import br.com.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {

    public static void main(String[] args) {
        String nome = "Valter";
        String cpf = "007.599.059-83";
        String email = "valterz@gmail.com";
        
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        RepositorioDeSelosEmMemoria repositorioDeSelosEmMemoria = new RepositorioDeSelosEmMemoria();
        
        publicador.adicionar(new LogDeAlunoMatriculado());
        publicador.adicionar(new GeraSeloAlunoNovato(repositorioDeSelosEmMemoria));

        MatricularAluno matricularAluno = new MatricularAluno(
                new RepositorioDeAlunosEmMemoria(), publicador);
        matricularAluno.executar(new MatricularAlunoDto(nome, cpf, email));
        
        repositorioDeSelosEmMemoria.selosDoAlunoDeCPF(new CPF(cpf)).forEach(System.out::println);;
    }

}
