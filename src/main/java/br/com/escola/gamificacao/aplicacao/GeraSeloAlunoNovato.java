package br.com.escola.gamificacao.aplicacao;

import br.com.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.escola.gamificacao.dominio.selo.Selo;
import br.com.escola.shared.dominio.CPF;
import br.com.escola.shared.dominio.evento.Evento;
import br.com.escola.shared.dominio.evento.Ouvinte;
import br.com.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
    
    private final RepositorioDeSelos repositorio;
    
    public GeraSeloAlunoNovato(RepositorioDeSelos repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    protected void reageAo(Evento evento) {
        CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
        Selo selo = new Selo(cpfDoAluno, "Novato");
        this.repositorio.adicionar(selo);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

}
