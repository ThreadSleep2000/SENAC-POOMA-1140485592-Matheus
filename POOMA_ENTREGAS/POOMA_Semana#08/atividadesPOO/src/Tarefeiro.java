import javax.swing.*;

public class Tarefeiro extends Funcionario{
    private double valorTarefa; // Armazena o valor da tarefa
    private int tarefasConcluidas; // Armazena a quantidade de tarefas concluídas
    private double salarioLiquido; // Armazena o salário líquido

    public Tarefeiro(){ // Construtor passa a função pelo nome da classe e define um valor inicial para a tarefa
        super.setFuncao(this.getClass().getSimpleName());
        this.valorTarefa = 10.00;
    }

    public double getValorTarefa() {
        return valorTarefa;
    }

    public void setValorTarefa() {
        this.valorTarefa = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da tarefa (R$): "));;
    }

    public int getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas() {
        this.tarefasConcluidas = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de tarefas concluídas: "));

    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = calcSalario();
    }

    public double calcSalario(){
        return getValorTarefa() * getTarefasConcluidas();
    }

    @Override
    public void imprimirHolerite() { // Sobrescreve o método da superclasse para si
        super.imprimirHolerite();
        System.out.println("Valor/tarefa: R$" + valorTarefa + "\nTarefas concluídas: " + tarefasConcluidas + "\nSalário Líquido: R$" + salarioLiquido);
    }
}
