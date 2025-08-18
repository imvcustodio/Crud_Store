package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ContaLuz {
    private Date dataPagamento;
    private Date dataLeitura;
    private int numLeitura;
    private double valorPagar;
    private double mediaConsumo;
    private int kwGasto;
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    public ContaLuz() {

    }

    public ContaLuz(Date dataPagamento, Date dataLeitura, int numLeitura, double valorPagar, int kwGasto) {
        this.dataPagamento = dataPagamento;
        this.dataLeitura = dataLeitura;
        this.numLeitura = numLeitura;
        this.valorPagar = valorPagar;
        this.kwGasto = kwGasto;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public Date getDataLeitura() {
        return dataLeitura;
    }
    public void setDataLeitura(Date dataLeitura) {
        this.dataLeitura = dataLeitura;
    }
    public Integer getNumLeitura() {
        return numLeitura;
    }
    public void setNumLeitura(Integer numLeitura) {
        this.numLeitura = numLeitura;
    }
    public Double getValorPagar() {
        return valorPagar;
    }
    public void setValorPagar(Double valorPgara) {
        this.valorPagar = valorPgara;
    }
    public double getMediaConsumo() {
        mediaConsumo = kwGasto/30.0;
        return mediaConsumo;
    }
    public void setMediaConsumo(Double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }
    public Integer getKwGasto() {
        return kwGasto;
    }

    public void setKwGasto(Integer kwGasto) {
        this.kwGasto = kwGasto;
    }
    public String toString(){
        return "Data leitura: "+sdf.format(dataLeitura) +",  nº Leitura: "+numLeitura+", Kw Gasto: "+kwGasto
                +",  valorPagar: "+valorPagar+", Data Pagamento: "+sdf.format(dataPagamento)+", Média Consumo: "+String.format("%.2f", getMediaConsumo());
    }

}
