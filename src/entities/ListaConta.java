package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ListaConta {
    private List<ContaLuz> contaLuz = new ArrayList<>();
    private ContaLuz conta = new ContaLuz();
    private Scanner scanner =  new Scanner(System.in);
    private int menorConsumo;
    private int maiorConsumo;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public ListaConta() {}

    public ListaConta(List<ContaLuz> contaLuz) {
        this.contaLuz = contaLuz;
    }

    public void addContaLuz() throws ParseException {
        System.out.println("Digite a data de leitura da conta: ");
        String dataLuz = scanner.next();
        Date dataLeituraCorrect = sdf.parse(dataLuz);
        System.out.println("Numero da leitura");
        int numeroLeituraLuz = scanner.nextInt();
        System.out.println("Kw Gasto: ");
        int kwGastoLuz = scanner.nextInt();
        System.out.println("Valor a pagar: ");
        double valorPagarLuz = scanner.nextDouble();
        System.out.println("Data Pagamento: ");
        String dataPagamentoLuz = scanner.next();
        Date dataPagamento = sdf.parse(dataPagamentoLuz);
        conta = new ContaLuz(dataPagamento, dataLeituraCorrect, numeroLeituraLuz, valorPagarLuz, kwGastoLuz);
        addContaInList(conta);
    }

    public void consultarConta() throws ParseException {
        System.out.println("Digite a data de leitura da conta: ");
        String dataVerificacao = scanner.next();
        Date dataVerificacaoformated = sdf.parse(dataVerificacao);

        for (ContaLuz c : contaLuz) {
            if (c.getDataLeitura().equals(dataVerificacaoformated)) {
                System.out.println("conta encontrada esta aqui a sua via: " + c);
                break;
            }
        }

    }

    public void deletarConta() throws ParseException {
        System.out.println("Digite a data de leitura da conta: ");
        String dataDelet = scanner.next();
        Date dataDeleteformated = sdf.parse(dataDelet);
        for (ContaLuz c : contaLuz) {
            if (c.getDataLeitura().equals(dataDeleteformated)) {
                System.out.println("conta cuja consta a data: "+sdf.format(c.getDataLeitura())+" , Deletada com sucesso!");
                contaLuz.remove(c);
                break;
            }
        }
    }

    public List<ContaLuz> getContaLuz() {
        return contaLuz;
    }
    public void setContaLuz(List<ContaLuz> contaLuz) {
        this.contaLuz = contaLuz;
    }

    public void addContaInList(ContaLuz conta) {
        contaLuz.add(conta);
    }

    public void exibirContas(){
        for (ContaLuz conta : contaLuz) {
            System.out.println(conta);
        }
    }

    public void menorConsumo(){
        menorConsumo = contaLuz.getFirst().getKwGasto();
        for(ContaLuz c:contaLuz){
            if (c.getKwGasto()<menorConsumo){
                menorConsumo = c.getKwGasto();
            }
        }
        System.out.println("Menor consumo: "+menorConsumo);
    }

    public void maiorConsumo(){
        for(ContaLuz c:contaLuz){
            if (c.getKwGasto()>maiorConsumo){
                maiorConsumo = c.getKwGasto();
            }
        }
        System.out.println("Maior consumo: "+maiorConsumo);
    }
}
