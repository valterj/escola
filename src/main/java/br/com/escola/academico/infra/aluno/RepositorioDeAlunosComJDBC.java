package br.com.escola.academico.infra.aluno;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.escola.academico.dominio.aluno.Aluno;
import br.com.escola.academico.dominio.aluno.RepositorioDeAlunos;
import br.com.escola.shared.dominio.CPF;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {
    
    private final Connection conenction;
    
    public RepositorioDeAlunosComJDBC(Connection conenction) {
        this.conenction = conenction;
    }

    @Override
    public void matricular(Aluno aluno) {
        try {
            String sql = "insert into aluno values(?, ?, ?)";
            var ps = conenction.prepareStatement(sql);
            ps.setString(1, aluno.getCpf().toString());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscarPorCPF(CPF cpf) {
        return null;
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return null;
    }

}
