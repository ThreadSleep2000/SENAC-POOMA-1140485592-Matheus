package Cadastros;

import Viagem.Carga;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class BDCadastros<T extends Pessoa> {
    private List<T> pessoas;

    public BDCadastros(){
        pessoas = new ArrayList<>();
    }

    public void adicionar(T pessoa){
        pessoas.add(pessoa);
    }

    public boolean remover(String documento){
        for(Pessoa pessoa : pessoas){
            if(documento.equalsIgnoreCase(pessoa.getDocumento())){
                System.out.println(pessoa.toString());

                String opcoes[] = {"Sim", "Não"};
                int escolha = -1; // Inicialize a escolha com um valor inválido

                escolha = JOptionPane.showOptionDialog(null,
                        "Deseja realmente excluir esse cadastro?",
                        "Menu de seleção de ação",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcoes,
                        opcoes[0]);

                if (escolha == 0) {
                    pessoas.remove(pessoa);
                    System.out.println("Cadastro removido.");
                    return true;
                }
            }
        }
        System.out.println("Documento informado não está cadastrado na base de dados.\n");
        return false;
    }

    public int tamanho(){
        return pessoas.size();
    }

    public T obter(int nro){
        return pessoas.get(nro);
    }

    public T obter(String documento){
        for(Pessoa pessoa : pessoas){
            if(documento.equalsIgnoreCase(pessoa.getDocumento())){
                return pessoas.get(pessoas.indexOf(pessoa));
            }
        }
        System.out.println("Não há cadastro com o documento informado.");
        return null;
    }

    public void listarPessoas(){
        System.out.println("\n:::::::: Lista de pessoas: ");
        for(T pessoa : pessoas){
            System.out.println("Tipo de cadastro: " + pessoa.getClass().getSimpleName());
            System.out.println(pessoa.toString() + "\n");
        }
    }
}
