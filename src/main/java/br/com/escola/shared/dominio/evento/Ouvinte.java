package br.com.escola.shared.dominio.evento;

public abstract class Ouvinte {
    
    public void processar(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reageAo(evento);
        }
    }

    protected abstract void reageAo(Evento evento);

    protected abstract boolean deveProcessar(Evento evento);

}
