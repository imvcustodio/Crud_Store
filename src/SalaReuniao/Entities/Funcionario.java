package SalaReuniao.Entities;

import java.time.LocalDateTime;

public class Funcionario {
    private String nome;
    private int ramalFuncionario;
    private Setor setorFuncionario;
    private Cargo cargoFuncionario = new Cargo();

    public Funcionario(String nome,  int ramalFuncionario, String cargoFuncionario) {
        setNomeFuncionario(nome);
        setRamalFuncionario(ramalFuncionario);
        this.cargoFuncionario.setNomeCargo(cargoFuncionario);
    }

    public void setNomeFuncionario(String nome) throws IllegalArgumentException{
        if (nome==null || nome.trim().isEmpty())
            throw new IllegalArgumentException("O nome do funcionário esta em um formato incorreto");
        this.nome = nome;
    }

    public void setRamalFuncionario(int ramalFuncionario) throws IllegalArgumentException {
        if (ramalFuncionario<=0)
            throw new IllegalArgumentException("Erro ramal informado não pode ser menor oi igual a zero!");
        this.ramalFuncionario = ramalFuncionario;
    }

    public String getNomeFuncionario() {
        return nome;
    }

    public int getRamalFuncionario() {
        return ramalFuncionario;
    }

    public Setor getSetorFuncionario() {
        return setorFuncionario;
    }

    public void setSetorFuncionario(Setor setorFuncionario) {
        if (setorFuncionario==null)
            throw new IllegalArgumentException("Setor deste funcionario é invalido!");
        this.setorFuncionario = setorFuncionario;
    }

    public String exibirfuncionario() {
        return "Nome: "+nome+"\n"+
                "Ramal: "+ramalFuncionario+"\n"+
                "Setor: "+ getSetorFuncionario() + "\n" +
                "Cargo: "+ cargoFuncionario.getNomeCargo();
    }
}
