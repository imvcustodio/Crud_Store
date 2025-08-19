package entities;

public class ItemCompra {
    private Produto produto;
    private int mesQuantity;
    private double compraQuantity;
    private double price;


    public ItemCompra(Produto produto, int mesQuantity, double compraQuantity, double price) {
        setProduto(produto);
        setMesQuantity(mesQuantity);
        setCompraQuantity(compraQuantity);
        setPrice(price);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getMesQuantity() {
        return mesQuantity;
    }

    public void setMesQuantity(int mesQuantity) {
        if (mesQuantity<0) {
            throw new IllegalArgumentException("A media de compras não pode ser negativa");
        }
        this.mesQuantity = mesQuantity;
    }

    public double getCompraQuantity() {
        return compraQuantity;
    }

    public void setCompraQuantity(double compraQuantity) {
        if (compraQuantity<0) {
            throw new IllegalArgumentException("A quantidade de nenhum produto pode ser negativa");
        }
        this.compraQuantity = compraQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price <=0.0) {
            throw new IllegalArgumentException("O preço não pode ser menor ou igual a zero");
        }
        this.price = price;
    }

    public double totalEstimado(){
        return mesQuantity*price;
    }

    @Override
    public String toString(){
        return "Nome Produto: " + this.produto.getNome()
                +"\nUnidade: " + this.produto.getUnidade().toString()
                +"\nQuantidade Mes: "+this.mesQuantity +"["+this.produto.getUnidade()+"]"
                +"\nQuantidade Compra: "+this.compraQuantity
                +"\nPreço estimado Unidade: R$"+this.price
                + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-";
    }
}
