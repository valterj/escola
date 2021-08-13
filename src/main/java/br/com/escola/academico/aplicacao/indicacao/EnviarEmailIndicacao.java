package br.com.escola.academico.aplicacao.indicacao;

import br.com.escola.academico.dominio.aluno.Aluno;

public interface EnviarEmailIndicacao {
    
    void enviarPara(Aluno indicado);
    
}
