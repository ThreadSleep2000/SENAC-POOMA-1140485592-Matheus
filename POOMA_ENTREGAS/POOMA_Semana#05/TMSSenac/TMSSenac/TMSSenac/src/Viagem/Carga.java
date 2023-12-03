package Viagem;

import Cadastros.Cliente;
import Cadastros.Motorista;
import Cadastros.Veiculo;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Carga {
    private long numeracao;
    private String rota, mercadoria, notas, status;
    private LocalDate dataColeta, dataEntrega;
    private double valorFrete;
    private Motorista motorista;
    private Veiculo veiculo;
    private Cliente remetente, destinatario, tomador;

    // Construtor
    public Carga(Cliente remetente, Cliente destinatario, Cliente tomador){
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.tomador = tomador;
        this.rota = remetente.getMunicipio() + " x " + destinatario.getMunicipio();
    }

    // Getters e setters
    public String getMercadoria(){
        return this.mercadoria;
    }

    public void setMercadoria(){
        this.mercadoria = JOptionPane.showInputDialog("Informe a mercadoria transportada: ");
    }

    public String getRota(){
        return this.rota;
    }

    public String getNotas(){
        return this.notas;
    }

    public void setNotas(){
        this.notas = JOptionPane.showInputDialog("Informe a(s) nota(s) transportadas: ");
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(int codStatus){
        String status[] = {"Aberta", "Em viagem", "Finalizada", "Cancelada"};
        this.status = status[codStatus];
    }

    public LocalDate getDataColeta(){
        return this.dataColeta;
    }

    public void setDataColeta(){
        String data = JOptionPane.showInputDialog("Informe a data de coleta: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataColeta = LocalDate.parse(data, formato);
    }

    public LocalDate getDataEntrega(){
        return this.dataEntrega;
    }

    public void setDataEntrega(){
        String data = JOptionPane.showInputDialog("Informe a data estimada de entrega: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dataEntrega = LocalDate.parse(data, formato);
    }

    public double getValorFrete(){
        return this.valorFrete;
    }

    public void setValorFrete(){
        this.valorFrete = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da negociação (R$): "));
    }

    public void setMotorista(Motorista motorista) {
        if(motorista.getApto() && motorista.getDisponivel()){
            this.motorista = motorista;
        } else{
            System.out.println("Motorista não está apto para transportar. Atualize os dados cadastrais.");
        }
    }

    public long getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(long numeracao) {
        this.numeracao = numeracao;
    }

    public void setVeiculo(Veiculo veiculo){
        if(veiculo.isApto() && veiculo.isDisponivel()){
            this.veiculo = veiculo;
        } else {
            System.out.println("O veículo não está apto para transportar. Atualize os dados cadastrais.");
        }
    }

    // Outros métodos
    public void exibirCarga(){
        if(motorista != null || veiculo != null) {
            System.out.println("\n\tRota: " + rota +
                    "\n\tRemetente: " + remetente.getNome() +
                    "\n\tDestinatario: " + destinatario.getNome() +
                    "\n\tTomador: " + tomador.getNome() +
                    "\n\tMercadoria: " + mercadoria +
                    "\n\tNotas: " + notas +
                    "\n\tColeta: " + dataColeta +
                    "\n\tEntrega: " + dataEntrega +
                    "\n\tMotorista: " + motorista.getNome() +
                    "\n\tVeiculo: " + veiculo.getPlaca() +
                    "\n\tValor do frete: R$" + valorFrete);
        }
        else{
            System.out.println("\n\tRota: " + rota +
                    "\n\tRemetente: " + remetente.getNome() +
                    "\n\tDestinatario: " + destinatario.getNome() +
                    "\n\tTomador: " + tomador.getNome() +
                    "\n\tMercadoria: " + mercadoria +
                    "\n\tNotas: " + notas +
                    "\n\tColeta: " + dataColeta +
                    "\n\tEntrega: " + dataEntrega +
                    "\n\tMotorista: não definido" +
                    "\n\tVeiculo: não definido" +
                    "\n\tValor do frete: R$" + valorFrete + "\n");
        }
    }
}
