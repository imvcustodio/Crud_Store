package SalaReuniao.Entities;

public class Cargo {
    private String nomeCargo;

    public Cargo(){

    }
    public Cargo(String nomeCargo) {
        setNomeCargo(nomeCargo);
    }
    public void setNomeCargo(String nomeCargo) {
        if (nomeCargo == null || nomeCargo.trim().isEmpty())//
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        this.nomeCargo = nomeCargo.trim();
    }
    public String getNomeCargo() {
        return nomeCargo;
    }
}
