package entities;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Compra {
    private List<ItemCompra> produtos =  new ArrayList<>();
    private Scanner scanner =  new Scanner(System.in);

    public Compra() {

    }
    public Compra(List<ItemCompra> produtos){
        this.produtos = produtos;
    }
    public List<ItemCompra> getProdutos(){
        return produtos;
    }
    public void setProdutos(List<ItemCompra> produtos){
        this.produtos = produtos;
    }

    public void addProduto(){
            Produto produto = new Produto();
            System.out.println("Digite o nome do produto");
            String nome = scanner.next();

            System.out.println("Escolha a unidade do produto");
                System.out.println("[1]LITRO\n"+
                "[2]KILO\n" +
                "[3]GM\n" +
                "[4]ML\n" +
                "[5]MG\n" +
                "[6]UNITÁRIO");
            System.out.println("Digite o numero da unidade do produto: ");
            int numero = scanner.nextInt();
            produto.setNome(nome);
            switch (numero){
                case 1:
                    produto.setUnidade(Unidade.LITRO);
                    break;
                case 2:
                    produto.setUnidade(Unidade.KILO);
                    break;
                case 3:
                    produto.setUnidade(Unidade.GM);
                    break;
                case 4:
                    produto.setUnidade(Unidade.MG);
                    break;
                case 5:
                    produto.setUnidade(Unidade.UNITARIO);
                    break;
            }


            System.out.println("Qual a quantidade em ["+ produto.getUnidade() +"] produto por mes em media: ");
            int mesQuantity = scanner.nextInt();

            System.out.println("Qual a quantidade do produto na compra: ");
            int quantity = scanner.nextInt();

            System.out.println("Qual o preço do produto: ");
            double price = scanner.nextDouble();

            ItemCompra itemCompra = new ItemCompra(produto, mesQuantity, quantity, price);

            System.out.println("Produto: "+produto.getNome()+" adicionado com sucesso");

            produtos.add(itemCompra);
    }

    public boolean removeProduto(){
        boolean retorno = false;
        System.out.println("Qual o nome do produto que deseja remover: ");
        String nome = scanner.next();

        for (ItemCompra produto : produtos) {
            if (produto.getProduto().getNome().equals(nome)) {
                System.out.println("Produto: "+produto.getProduto().getNome()+" removido com sucesso!");
                produtos.remove(produto);
                retorno = true;
                break;
            }
        }
        return retorno;
    }

    public void listarProdutos(){
        for(ItemCompra produto : produtos){
            System.out.println(produto);
        }
    }

    public void atualizarProdutoMenu(){
        System.out.println("Qual o nome do produto que deseja fazer alguma alteração: ");
        String nome = scanner.next();
        for (ItemCompra produto : produtos) {
            if (produto.getProduto().getNome().equals(nome)) {
                System.out.println("Opções de atualização");
                System.out.println("Atualizar Preço [1]");
                System.out.println("Atualizar Preço e Quantidade Compra [2]");
                System.out.println("Atualizar Preço e Quantidade Compra e Quantidade mes[3]");
                System.out.println("Digite a opção deseja atualizar: ");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1:
                        System.out.println("Qual o preço que deseja atualizar: ");
                        double preco = scanner.nextDouble();
                        alterarItem(produto, preco);
                        break;
                    case 2:
                        System.out.println("Qual o preço que deseja atualizar: ");
                        preco = scanner.nextDouble();
                        System.out.println("Qual a nova quantia para mes: ");
                        double quantidadeCompra = scanner.nextInt();
                        alterarItem(produto, preco, quantidadeCompra);
                        break;
                    case 3:
                        System.out.println("Qual o preço que deseja atualizar: ");
                        preco = scanner.nextDouble();
                        System.out.println("Qual a nova quantia para mes: ");
                        int quantidadeMes = scanner.nextInt();
                        System.out.println("Quantidade compra para atualizar: ");
                        quantidadeCompra = scanner.nextDouble();
                        alterarItem(produto, preco, quantidadeCompra, quantidadeMes);
                        break;
                }
            }
        }
    }

    public void alterarItem(ItemCompra produto, double price){
        produto.setPrice(price);
    }
    public void alterarItem(ItemCompra produto, double price, double quantidadeCompra){
        produto.setPrice(price);
        produto.setCompraQuantity(quantidadeCompra);
    }
    public void alterarItem(ItemCompra produto, double price, double quantidadeCompra, int quantidadeMes){
        produto.setPrice(price);
        produto.setCompraQuantity(quantidadeCompra);
        produto.setMesQuantity(quantidadeMes);
    }

    public double totalizarCompra(){
        double soma = 0.0;
        for (ItemCompra produto : produtos) {
           soma+=produto.totalEstimado();
        }
        return soma;
    }

}
