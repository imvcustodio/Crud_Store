package Program;
import entities.ListaConta;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public Program(){
        Scanner sc = new Scanner(System.in);
        boolean aprovation = false;
        ListaConta listaConta = new ListaConta();
        do {
                try{
                    System.out.println("-=-=-=-=-=Bem vindo ao sistema de Organização com suas contas de Luz-=-=-=-=-=");
                    System.out.println("Menu");
                    System.out.println("1 - Adicionar Conta de Luz");
                    System.out.println("2 - Consultar Conta de Luz");
                    System.out.println("3 - Deletar Conta de Luz");
                    System.out.println("4 - Listar Conta de Luz");
                    System.out.println("5 - Maior consumo");
                    System.out.println("6 - Menor consumo");
                    System.out.println("7 - Sair do sistema");
                    System.out.println("Opção: ");
                    int option = sc.nextInt();
                    sc.nextLine();
                    switch (option) {
                        case 1:
                            listaConta.addContaLuz();
                            break;
                        case 2:
                            listaConta.consultarConta();
                            break;
                        case 3:
                            listaConta.deletarConta();
                            break;
                        case 4:
                            listaConta.exibirContas();
                            break;
                        case 5:
                            listaConta.maiorConsumo();
                            break;
                        case 6:
                            listaConta.menorConsumo();
                            break;
                        case 7:
                            aprovation = true;
                            break;

                    }
                }catch(InputMismatchException | ParseException e){
                    System.out.println("entrada invalida");
                    break;
                }



        }while(!aprovation);



        sc.close();
    }
    public static void main(String[] args) {
        new Program();
    }
}
