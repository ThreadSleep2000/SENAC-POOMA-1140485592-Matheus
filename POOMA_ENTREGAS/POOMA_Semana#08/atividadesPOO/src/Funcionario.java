import javax.swing.*;

public class Funcionario {
    protected String nome;
    protected String depto;
    protected String funcao;

    public String getNome() {
        return nome;
    }

    public void setNome() {
        this.nome = JOptionPane.showInputDialog("Informe o nome do funcionário: ");
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto() {
        this.depto = JOptionPane.showInputDialog("Informe o departamento: ");
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void imprimirHolerite(){
        System.out.println("\nNome: " + nome + "\nDepto: " + depto + "\nFunção: " + funcao);
    }
}
