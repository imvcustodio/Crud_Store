package SalaReuniao.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ReservaMes {

    private List<Reserva> listaDeReservas;
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Funcionario addFuncionario() {
        System.out.println("Qual o nome do funcionario responsavel pela reserva: ");
        String nomeFuncionario = scanner.nextLine();
        System.out.println("Ramal: ");
        int ramal = scanner.nextInt();
        System.out.println("Cargo ocupante: ");
        String cargo = scanner.next();

        Funcionario funcionario = new Funcionario(nomeFuncionario, ramal, cargo);

        System.out.println("Setor do Funcionario: ");
        System.out.println("DIRETORIA [1]");
        System.out.println("DESENVOLVIMENTO [2]");
        System.out.println("SUPORTE [3]");
        System.out.println("QUAL O SETOR: ");
        int setorFuncionario = scanner.nextInt();
        scanner.nextLine();
        switch (setorFuncionario){
            case 1:
                funcionario.setSetorFuncionario(Setor.DIRETORIA);
                break;
            case 2:
                funcionario.setSetorFuncionario(Setor.DESENVOLVIMENTO);
                break;
            case 3:
                funcionario.setSetorFuncionario(Setor.SUPORTE);
                break;
        }
        return funcionario;
    }

    public void realizarReserva(){
        Funcionario funcionario = addFuncionario();
        System.out.println("-=-=-=-=-=-=-=-=-");
        System.out.println("Qual o horario de inicio da Reuniao: (dd-MM-yyyy HH:mm:ss) ");
        String horarioInicio = scanner.nextLine();
        LocalDateTime dataHoraInicio = LocalDateTime.parse(horarioInicio, formatter);

        System.out.println("Qual o horario de Fim da Reuniao: (dd-MM-yyyy HH:mm:ss) ");
        String horarioFim = scanner.nextLine();
        LocalDateTime dataHoraFim = LocalDateTime.parse(horarioFim, formatter);
        System.out.println("-=-=-=-=-=-=-=-=-");
        System.out.println("Qual a capacidade de pessoas da sala: ");
        int quantidadePessoasSala = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Qual o numero da sala: ");
        int numeroSala = scanner.nextInt();
        scanner.nextLine();
        SalaReuniao sala = new SalaReuniao(quantidadePessoasSala, numeroSala);
        System.out.println("-=-=-=-=-=-=-=-=-");

        Reserva reserva = new Reserva(dataHoraInicio, dataHoraFim, sala);
        reserva.addFuncionario(funcionario);
        boolean resposta = true;
        do {
            System.out.println("Gostaria de adicionar mais 1 funcionario para esta reserva: ");
            System.out.println("Sim [1]");
            System.out.println("Não [2]");
            System.out.println("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();
            if(opcao == 1){
                    Funcionario funcionarioAdd = addFuncionario();
                    reserva.addFuncionario(funcionarioAdd);
            }else if(opcao == 2){
                resposta = false;
            }else System.out.println("Opção invalida!");

        }while(resposta);


        //listaDeReservas.add(reserva);
    }
    public void mudarHorario(){

    }
    public void realocarReserva(){

    }
}
