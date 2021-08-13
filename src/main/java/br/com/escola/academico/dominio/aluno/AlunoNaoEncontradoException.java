package br.com.escola.academico.dominio.aluno;

import br.com.escola.shared.dominio.CPF;

public class AlunoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontradoException(CPF cpf) {
        super(String.format("Não encontrado aluno com CPF %s.", cpf.getNumero()));
    }
    
}
