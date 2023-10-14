package Cadastros;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Motorista extends Pessoa{
    private long cnh;
    private LocalDate emissao;
    private boolean apto, disponivel;

    // Construtores
    public Motorista(){
        super();
        this.setCnh();
    }

    // Getters and setters
    public long getCnh() {
        return cnh;
    }

    public void setCnh(){
        this.cnh = Long.parseLong(JOptionPane.showInputDialog("Informe a CNH: "));

        String data = JOptionPane.showInputDialog("Informe a data de emissão: ");
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate emissao = LocalDate.parse(data, formato);
        LocalDate hoje = LocalDate.now();

        if(hoje.isBefore(emissao.plusYears(10))){
            this.apto = true;
            this.disponivel = true;
            this.emissao = emissao;
        }
        else{
            this.apto = false;
            this.disponivel = false;
            System.out.println("Documento vencido. Informe um documento válido.");
            setCnh();
        }
    }

    public LocalDate getEmissao(){
        return emissao;
    }

    public boolean getApto(){
        return apto;
    }

    public boolean getDisponivel(){ return disponivel; }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\tCNH: " + this.cnh + "\n\tData de emissão: " + this.emissao + "\n\tApto para transportar?: " + this.apto + "\n\tDisponível?: " + this.disponivel;
    }
}
