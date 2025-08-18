package Program;
import entities.Compra;
import entities.Produto;
import entities.Unidade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ProgramexerciseClass {

    public ProgramexerciseClass(){
        boolean progress = true;
        Compra compra = new Compra();
        Scanner scanner = new Scanner(System.in);

                do {
                    try{
                        System.out.println("-=-=-=-=-=-=- Menu Opções -=-=-=-=-=-=-");
                        System.out.println("1 adicionar novo produto");
                        System.out.println("2 Listar produtos");
                        System.out.println("3 Remover Produto");
                        System.out.println("4 atualizar produto");
                        System.out.println("5 Sair");
                        System.out.println("Opção desejada: ");
                        int option = scanner.nextInt();
                        switch (option) {
                            case 1:
                                compra.addProduto();
                            break;
                            case 2:
                                compra.listarProdutos();
                                break;
                            case 3:
                                compra.removeProduto();
                                break;
                            case 4:
                                compra.atualizarProdutoMenu();
                                break;
                            case 5:
                                progress = false;
                                break;
                        }

                    }catch (InputMismatchException e){
                        System.out.println(e.getMessage());
                    }
                }while (progress);

        scanner.close();
    }
    public static void main(String[] args) {
        new ProgramexerciseClass();
    }
}
