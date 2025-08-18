package entities;

public class Produto {
    private String nome;
    private Unidade unidade;

    public Produto(){

    }
    public Produto(String nome, Unidade unidade){
        setNome(nome);
        setUnidade(unidade);
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        if (nome == null || nome.trim().isEmpty())
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio.");
        this.nome = nome.trim();
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) throws IllegalArgumentException{
        if (unidade == null)
            throw new IllegalArgumentException("Valor enviado para unidade de produto invalido!");

        this.unidade = unidade;
    }

}
