package br.com.escola.academico.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.escola.academico.dominio.aluno.Aluno;
import br.com.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.escola.shared.dominio.CPF;
import br.com.escola.shared.dominio.evento.PublicadorDeEventos;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerPersistido() {
        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionar(new LogDeAlunoMatriculado());
        
        RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
        
        MatricularAlunoDto dados = new MatricularAlunoDto(
                "Valter", "007.599.059-83", "valterz@gmail.com");
        useCase.executar(dados);
        
        Aluno aluno = repositorio.buscarPorCPF(new CPF("007.599.059-83"));
        assertEquals("Valter", aluno.getNome());
        assertEquals("007.599.059-83", aluno.getCpf().getNumero());
        assertEquals("valterz@gmail.com", aluno.getEmail());
    }

}
