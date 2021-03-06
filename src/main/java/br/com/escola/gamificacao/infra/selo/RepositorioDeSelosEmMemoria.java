package br.com.escola.gamificacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.escola.gamificacao.dominio.selo.Selo;
import br.com.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {
    
    private List<Selo> selos = new ArrayList<>();

    @Override
    public void adicionar(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> selosDoAlunoDeCPF(CPF cpf) {
        return this.selos
                .stream()
                .filter(selo -> selo.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }

}
