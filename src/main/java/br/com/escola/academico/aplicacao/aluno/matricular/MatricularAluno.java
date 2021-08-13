package br.com.escola.academico.aplicacao.aluno.matricular;

import br.com.escola.academico.dominio.aluno.Aluno;
import br.com.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAluno {
    
    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador) {
        this.repositorio = repositorio;
        this.publicador = publicador;
    }
    
    public void executar(MatricularAlunoDto dados) {
        Aluno novo = dados.criarAluno();
        this.repositorio.matricular(novo);
        
        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        this.publicador.publicar(evento);
    }

}
