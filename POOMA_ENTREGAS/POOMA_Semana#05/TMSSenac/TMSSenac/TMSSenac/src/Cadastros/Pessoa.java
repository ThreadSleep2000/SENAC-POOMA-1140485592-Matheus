package Cadastros;

import javax.swing.*;

public class Pessoa {
    // Atributos
    protected String nome;
    protected String documento;
    protected String tipo;

    // Construtores
    public Pessoa(){
        this.nome = JOptionPane.showInputDialog("Informe o nome / razão social: ").toUpperCase();
        this.documento = JOptionPane.showInputDialog("Informe o CPF / CNPJ (só números):");
        if(this.documento.length() == 11){
            this.tipo = "CPF";
        }
        else if(this.documento.length() == 14){
            this.tipo = "CNPJ";
        }
        else{
            System.out.println("Erro: documento inválido");
            this.setDocumento();
        }
    }

    // Getters e setters
    public void setNome(){
        this.nome = JOptionPane.showInputDialog("Informe o nome / razão social: ").toUpperCase();
    }

    public String getNome(){
        return this.nome;
    }

    public void setDocumento(){
        this.documento = JOptionPane.showInputDialog("Informe o CPF / CNPJ");
        if(this.documento.length() == 11){
            this.tipo = "CPF";
        }
        else if(this.documento.length() == 14){
            this.tipo = "CNPJ";
        }
        else{
            System.out.println("Erro: documento inválido");
            this.setDocumento();
        }
    }

    public String getDocumento(){
        return this.documento;
    }

    public String getTipo(){
        return this.tipo;
    }

    // Métodos
    @Override
    public String toString(){
        return "\n\tTipo: " + this.tipo +
                "\n\tNome/Razão: " + this.nome +
                "\n\tCPF/CNPJ: " + this.documento;
    }

}
