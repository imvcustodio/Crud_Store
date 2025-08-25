package SalaReuniao.Entities;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReservaMes {

    private List<Reserva> listaDeReservas = new ArrayList<Reserva>();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public Funcionario addFuncionario() {
        System.out.println("FUNCIONARIO");
        System.out.println("Digite o nome do funcionario: ");
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
    public boolean veryfyTime(LocalDateTime timeStart, LocalDateTime timeEnd, int numeroSala) {
        if (!listaDeReservas.isEmpty()){
            for(Reserva reserva : listaDeReservas){
                if (reserva.getSalaReuniao().getNumeroSala() == numeroSala){
                    if (
                            timeStart.equals(reserva.getDataReservaInicio()) || timeEnd.equals(reserva.getDataReservaFim()) ||
                            timeStart.isBefore(reserva.getDataReservaInicio()) && timeEnd.isAfter(reserva.getDataReservaInicio()) ||
                            timeStart.isBefore(reserva.getDataReservaInicio()) && timeEnd.isAfter(reserva.getDataReservaFim()) ||
                            timeStart.isAfter(reserva.getDataReservaInicio()) && timeStart.isBefore(reserva.getDataReservaFim())||
                            timeStart.isAfter(reserva.getDataReservaInicio()) && timeEnd.isBefore(reserva.getDataReservaFim())
                    ){
                        return false; // conflito
                    }

                }
            }
        }
        return true;
    }

    public void realizarReserva(){
        Funcionario funcionario = addFuncionario();
        System.out.println("-=-=-=-=-=-=-=-=-");
        System.out.println("RESERVA");
        System.out.println("Digite o ID da reserva: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        boolean idValid = false;
            if (!listaDeReservas.isEmpty()){
                while (!idValid){
                    for(Reserva reserva : listaDeReservas){
                        if(reserva.getId() == ID){
                            System.out.println("o Id que você digitou ja exite, escolha outro: ");
                            ID = scanner.nextInt();
                            idValid = true;
                            break;
                        }
                    }
                    idValid = true;
                }
            }

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
        boolean time = veryfyTime(dataHoraInicio, dataHoraFim, numeroSala);
        boolean validMeet = false;
        Reserva reserva = null;

        while (!validMeet){
            if (time){
                reserva = new Reserva(ID,dataHoraInicio, dataHoraFim, sala);
                validMeet = true;
            }else {
                System.out.println("Existe uma reuniao ja marcada para esta sala nesse intervalo de tempo!");
                System.out.println("Digite um novo horario para verificar a disponibilidade da sala ");
                System.out.println("Qual o horario de inicio da Reuniao: (dd-MM-yyyy HH:mm:ss) ");
                horarioInicio = scanner.nextLine();
                dataHoraInicio = LocalDateTime.parse(horarioInicio, formatter);

                System.out.println("Qual o horario de Fim da Reuniao: (dd-MM-yyyy HH:mm:ss) ");
                horarioFim = scanner.nextLine();
                dataHoraFim = LocalDateTime.parse(horarioFim, formatter);
                time = veryfyTime(dataHoraInicio, dataHoraFim, numeroSala);
            }
        }
        System.out.println("-=-=-=-=-=-=-=-=-");

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
                if (reserva.getFuncionarios().size()<quantidadePessoasSala) {
                    Funcionario funcionarioAdd = addFuncionario();
                    reserva.addFuncionario(funcionarioAdd);
                }else {
                    System.out.println("A sala ja atingiu seu limite de ocupantes");
                    resposta = false;
                }
            }else if(opcao == 2){
                resposta = false;
            }else System.out.println("Opção invalida!");

        }while(resposta && reserva.getFuncionarios().size()<quantidadePessoasSala);


        listaDeReservas.add(reserva);
    }

    public void mostrarReservas(){
        for (Reserva reserva : listaDeReservas) {
            System.out.println(reserva.toString());
        }
    }

    public void alterarReserva(){
        System.out.println("Informe o Id da Reserva que deseja alterar: ");
        int ID = scanner.nextInt();
        scanner.nextLine();
        for(Reserva reserva : listaDeReservas){
            if(reserva.getId() == ID){
                System.out.println("Reserva encontrada!");
                System.out.println("Qual a informação deseja alterar");
                System.out.println("[1] Data e horário reuniao");
                System.out.println("[2] ID da reuniao");
                System.out.println("[3] adicionar novo funcionario para a reuniao");
                int opcao = scanner.nextInt();
                scanner.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("A reuniao esta marcada para iniciar as, "+reserva.getDataReservaInicio().format(formatter)+", e terminar as,"+reserva.getDataReservaFim().format(formatter));
                        System.out.println("Digite o novo horario de inicio: ");

                        String horarioInicio = scanner.nextLine();
                        LocalDateTime dataHoraInicio = LocalDateTime.parse(horarioInicio, formatter);
                        System.out.println("Digite o novo horario de Fim: ");
                        String horarioFim = scanner.nextLine();
                        LocalDateTime dataHoraFim = LocalDateTime.parse(horarioFim, formatter);

                        if (veryfyTime(dataHoraInicio, dataHoraFim, reserva.getSalaReuniao().getNumeroSala())){
                            reserva.setDataInicioReuniao(dataHoraInicio, dataHoraFim);
                            reserva.setDataReservaFim(dataHoraFim, dataHoraInicio);
                            System.out.println("Reserva alterada com sucesso!");
                            System.out.println("Agora a reuniao esta marcada para iniciar as, "+reserva.getDataReservaInicio().format(formatter)+", e terminar as,"+reserva.getDataReservaFim().format(formatter));
                        }System.out.println("Horario indisponivel");
                        break;

                    case 2:
                        System.out.println("Digite o novo ID da reserva: ");
                        int novoID = scanner.nextInt();
                        scanner.nextLine();
                        reserva.setId(novoID);
                        System.out.println("ID da reserva alterada com sucesso!");
                        break;
                    case 3:
                        if (reserva.getSalaReuniao().getQuantidadeLugares()<reserva.getFuncionarios().size()){
                            Funcionario novoFuncionarioReuniao = addFuncionario();
                            reserva.addFuncionario(novoFuncionarioReuniao);
                            break;
                        }System.out.println("A sala ja esta cheia!");

                }
            }
        }
    }
    public void removerReserva(){
        System.out.println("Digite o ID da Reserva que voce deseja remover: ");
        int id = scanner.nextInt();

        for (Reserva reserva : listaDeReservas) {
            if (reserva.getId() == id) {
                System.out.println("A reserva cujo tem ID: "+ reserva.getId() +" estava marcado para iniciar as, "+ reserva.getDataReservaInicio()+", e acabar as, "+ reserva.getDataReservaFim()+", foi removida com sucesso!: ");
                listaDeReservas.remove(reserva);
                break;
            }
        }
    }
}
