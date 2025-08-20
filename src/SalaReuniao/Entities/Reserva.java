package SalaReuniao.Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Reserva {
    private LocalDateTime dataReservaInicio;
    private LocalDateTime dataReservaFim;
    private SalaReuniao salaReuniao;
    private List<Funcionario> funcionarios;
    private DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");


    public Reserva(LocalDateTime dataReservaInicio, LocalDateTime dataReservaFim, SalaReuniao salaReuniao) {
        setDataInicioReuniao(dataReservaInicio,  dataReservaFim);
        setDataReservaFim(dataReservaFim,   dataReservaInicio);
        this.salaReuniao = salaReuniao;
    }

    public void addFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }

    public void setDataInicioReuniao(LocalDateTime dataReservaInicio,  LocalDateTime dataReservaFim) {
        if (dataReservaInicio == null || dataReservaInicio.isAfter(dataReservaFim))
            throw new IllegalArgumentException("Horario de inicio da reunião não pode ser depois do Fim!");
        this.dataReservaInicio = dataReservaInicio;
    }

    public void setDataReservaFim(LocalDateTime dataReservaFim,  LocalDateTime dataReservaInicio) {
        if (dataReservaFim == null || dataReservaFim.isBefore(dataReservaInicio))
            throw new IllegalArgumentException("Horario que a reuniao acaba não pode ser antes do inicio da reuniao!");
        this.dataReservaFim = dataReservaFim;
    }

    @Override
    public String toString() {
        return "Reserva para os funcionarios: "+funcionarios.toString()+"\n"+
                "Data e Hora inicio da reuniao: "+dataReservaInicio.format(customFormatter)+
                "Data e Hora fim: "+dataReservaFim.format(customFormatter);
    }


}
