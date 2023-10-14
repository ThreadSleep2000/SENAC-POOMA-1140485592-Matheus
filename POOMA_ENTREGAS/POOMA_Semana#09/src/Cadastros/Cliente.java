package Cadastros;

import javax.swing.*;

public class Cliente extends Pessoa{
    private String municipio;
    private double credito;
    private boolean apto;

    // Construtores
    public Cliente(){
        super();
        setMunicipio();
        setCredito();
    }

    public String getMunicipio(){
        return this.municipio;
    }

    public void setMunicipio(){
        this.municipio = JOptionPane.showInputDialog("Informe o município: ");
    }
    public double getCredito(){
        return this.credito;
    }

    public void setCredito(){
        this.credito = Double.parseDouble(JOptionPane.showInputDialog("Informe o crédito liberado para o cliente: "));
        if(this.credito > 0){
            this.apto = true;
        }
        else{
            this.apto = false;
        }
    }

    public boolean getApto(){
        return this.apto;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\tMunicípio: " + this.municipio + "\n\tCrédito disponível: R$" + this.credito + "\n\tApto para transportar?: " + this.apto;
    }
}
