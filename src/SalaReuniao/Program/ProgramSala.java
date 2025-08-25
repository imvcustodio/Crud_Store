package SalaReuniao.Program;

import SalaReuniao.Entities.ReservaMes;

import java.util.Scanner;

public class ProgramSala {

    public ProgramSala() {
        Scanner scanner = new Scanner(System.in);
        ReservaMes reservaMes = new ReservaMes();
        try {
            boolean aprovacao = true;
            do {
                System.out.println("-=-=-=-=SISTEMA DE RESERVAS DE REUNIAO-=-=-=-=");
                System.out.println("Adicionar reserva [1]");
                System.out.println("Remover reserva [2]");
                System.out.println("Alterar reserva [3]");
                System.out.println("Mostrar reservas [4]");
                System.out.println("Sair [5]");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        reservaMes.realizarReserva();
                        break;
                    case 2:
                        reservaMes.removerReserva();
                        break;
                    case 3:
                        reservaMes.alterarReserva();
                        break;
                    case 4:
                        reservaMes.mostrarReservas();
                        break;
                    case 5:
                        aprovacao = false;
                        break;
                }
            } while (aprovacao);
        }catch(Exception e) {
            e.printStackTrace();
        }
        scanner.close();
    }
    public static void main(String[] args) {
        new ProgramSala();
    }
}
