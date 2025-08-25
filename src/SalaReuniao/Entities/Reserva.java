package SalaReuniao.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int ID;
    private LocalDateTime dataReservaInicio;
    private LocalDateTime dataReservaFim;
    private SalaReuniao salaReuniao;
    private List<Funcionario> funcionarios =  new ArrayList<>();
    private static DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public Reserva(int ID, LocalDateTime dataReservaInicio, LocalDateTime dataReservaFim, SalaReuniao salaReuniao) {
        setId(ID);
        setDataInicioReuniao(dataReservaInicio,  dataReservaFim);
        setDataReservaFim(dataReservaFim, dataReservaInicio);
        this.salaReuniao = salaReuniao;
    }
    public void setId(int ID) {
        if (ID >= 0) {
            this.ID = ID;
        }
    }
    public int getId() {
        return ID;
    }
    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public LocalDateTime getDataReservaInicio() {
        return dataReservaInicio;
    }

    public LocalDateTime getDataReservaFim() {
        return dataReservaFim;
    }


    public void setDataInicioReuniao(LocalDateTime dataReservaInicio,  LocalDateTime dataReservaFim) throws IllegalArgumentException {
        if (dataReservaInicio == null || dataReservaInicio.isAfter(dataReservaFim))
            throw new IllegalArgumentException("Horario de inicio da reunião não pode ser depois do Fim!");
        this.dataReservaInicio = dataReservaInicio;
    }

    public void setDataReservaFim(LocalDateTime dataReservaFim,  LocalDateTime dataReservaInicio) throws  IllegalArgumentException {
        if (dataReservaFim == null || dataReservaFim.isBefore(dataReservaInicio))
            throw new IllegalArgumentException("Horario que a reuniao acaba não pode ser antes do inicio da reuniao!");
        this.dataReservaFim = dataReservaFim;
    }
    public String listarFuncionarios(){
        int contador = 0;
        for (Funcionario funcionario : funcionarios) {
            contador++;
            if (contador == 1){
                System.out.println("Responsavel pelo agendamento: ");
            }else System.out.println("Funcionario Participante: ");
            System.out.println(funcionario.exibirfuncionario());
        }
        return "";
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public SalaReuniao getSalaReuniao() {
        return salaReuniao;
    }

    @Override
    public String toString() {
        return listarFuncionarios()+"\n"+
                "ID da reunião: "+getId()+"\n"+
                "Data e Hora inicio da reuniao: "+dataReservaInicio.format(customFormatter)+
                ", Data e Hora fim: "+dataReservaFim.format(customFormatter)+"\n"
                +"Número da Sala: "+salaReuniao.getNumeroSala()+"\n"
                +"Capacidade da sala: " +salaReuniao.getQuantidadeLugares();
    }


}
