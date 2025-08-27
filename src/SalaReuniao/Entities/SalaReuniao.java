package SalaReuniao.Entities;

public class SalaReuniao {
    private int quantidadeLugares;
    private int numeroSala;
    //tentar implementar a lista de horarios ideia bernardo

    public SalaReuniao(int quantidadeLugares, int numeroSala) {
        setQuantidadeLugares(quantidadeLugares);
        setNumeroSala(numeroSala);
    }

    public void setNumeroSala(int numeroSala) {
        if (numeroSala >= 0) {
            this.numeroSala = numeroSala;
        }
    }
    public void setQuantidadeLugares(int quantidadeLugares) {
        if (quantidadeLugares >= 0) {
                this.quantidadeLugares = quantidadeLugares;
        }
    }
    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }
    public int getNumeroSala() {
        return numeroSala;
    }

}
