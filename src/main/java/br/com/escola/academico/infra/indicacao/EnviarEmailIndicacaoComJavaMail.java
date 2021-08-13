package br.com.escola.academico.infra.indicacao;

import br.com.escola.academico.aplicacao.indicacao.EnviarEmailIndicacao;
import br.com.escola.academico.dominio.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {

    @Override
    public void enviarPara(Aluno indicado) {
        System.out.println(String.format("E-mail enviado para o aluno s%", indicado.getNome()));
    }

}
