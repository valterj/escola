package br.com.escola.shared.dominio;

import java.util.Objects;

public class CPF {
    
    private String numero;

    public CPF(String numero) {
        if(numero == null ||
                !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF invalido!");
        }
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CPF other = (CPF) obj;
        return Objects.equals(numero, other.numero);
    }

    @Override
    public String toString() {
        return this.getNumero();
    }
    
}
