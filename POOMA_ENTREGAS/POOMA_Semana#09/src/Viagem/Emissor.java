package Viagem;

import java.time.LocalDate;
public class Emissor {
    // Atributos
    private long numeracao;
    private LocalDate dataEmissao;
    private Carga carga;
    private String status;

    // Construtores
    public Emissor(Carga carga){
        this.carga = carga;
        this.dataEmissao = LocalDate.now();
        setStatus(0);
    }

    public LocalDate getDataEmissao(){
        return dataEmissao;
    }

    public Carga getCarga(){
        return carga;
    }

    public long getNumeracao(){
        return numeracao;
    }

    public String getStatus(){
        return status;
    }

    public void setNumeracao(long numeracao){
        this.numeracao = numeracao;
    }

    public void setStatus(int cod){
        String status[] = {"Autorizado", "Cancelado", "Rejeitado"};
        this.status = status[cod];
    }

    public void imprimirDocumentacao(){
        System.out.println("Nro: " + this.numeracao + "\nData de emissão: " + this.dataEmissao + "\nStatus: " + this.status);
        this.carga.exibirCarga();
    }


}
