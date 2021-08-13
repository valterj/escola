package br.com.escola.academico.dominio.aluno;

import java.util.Objects;

public class Email {
    
    private String endereco;
    
    public Email(String endereco) {
        if (endereco == null || !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }
        this.endereco = endereco;
    }
    
    public String getEndereco() {
        return endereco;
    }

    @Override
    public int hashCode() {
        return Objects.hash(endereco);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Email other = (Email) obj;
        return Objects.equals(endereco, other.endereco);
    }
    
}
