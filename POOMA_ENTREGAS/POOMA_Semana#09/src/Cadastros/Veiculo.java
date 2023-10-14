package Cadastros;

import javax.swing.*;

public class Veiculo {
    private String placa;
    private int ano;
    private String modelo;
    private String renavam;
    private Proprietario proprietario;
    private boolean apto, disponivel;

    // Construtor
    public Veiculo(){
        setPlaca();
        setModelo();
        setAno();
        setRenavam();
        this.apto = false;
        this.disponivel = false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(){
        this.placa = JOptionPane.showInputDialog("Informe a placa: ");
    }

    public int getAno() {
        return ano;
    }

    public void setAno(){
        this.ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano: "));
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(){
        this.modelo = JOptionPane.showInputDialog("Informe o modelo: ");
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(){
        String nroRenavam = JOptionPane.showInputDialog("Informe o RENAVAM: ");
        while(nroRenavam.length() != 11){
            System.out.println("Número inválido. Informe um número válido.");
            setRenavam();
        }
        this.renavam = nroRenavam;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario){
        this.proprietario = proprietario;
        this.apto = true;
        this.disponivel = true;
    }

    public boolean isApto() {
        return apto;
    }

    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString(){
        if(proprietario != null) {
            return "\n\tPlaca: " + placa + "\n\tModelo: " + modelo + "\n\tAno: " + ano + "\n\tRENAVAM: " + renavam + "\n\tProprietário: " + proprietario.getNome() + "\n\tApto: " + apto + "\n\tDisponível?: " + disponivel;
        }
        else{
            return "\n\tPlaca: " + placa + "\n\tModelo: " + modelo + "\n\tAno: " + ano + "\n\tRENAVAM: " + renavam + "\n\tProprietário: não cadastrado" + "\n\tApto: " + apto + "\n\tDisponível?: " + disponivel;
        }
    }
}
