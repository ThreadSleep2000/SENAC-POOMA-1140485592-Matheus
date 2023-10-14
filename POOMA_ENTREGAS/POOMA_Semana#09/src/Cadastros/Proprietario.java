package Cadastros;

import javax.swing.*;
import java.time.LocalDate;

public class Proprietario extends Pessoa{
    // Atributos
    private String rntrc;

    // Construtores
    public Proprietario(){
        super();
        setRntrc();
    }

    public void setRntrc(){
        this.rntrc = JOptionPane.showInputDialog("Informe o número do RNTRC: ");
    }

    public String getRntrc(){
        return rntrc;
    }

    @Override
    public String toString(){
        return super.toString() + "\n\tRNTRC: " + this.rntrc;
    }
}
