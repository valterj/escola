package br.com.escola.gamificacao.dominio.selo;

import br.com.escola.shared.dominio.CPF;

public class Selo {

    private CPF cpfDoAluno;
    private String nome;

    public Selo(CPF cpfDoAluno, String nome) {
        this.cpfDoAluno = cpfDoAluno;
        this.nome = nome;
    }

    public CPF getCpfDoAluno() {
        return cpfDoAluno;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return String.format("Selo [cpfDoAluno=%s, nome=%s]", cpfDoAluno, nome);
    }
    
}
