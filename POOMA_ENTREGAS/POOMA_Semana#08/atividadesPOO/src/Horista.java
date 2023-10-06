import javax.swing.*;

public class Horista extends Funcionario{
    private double valorHora; // Armazena o valor por hora trabalhada
    private int horasTrabalhadas; // Armazena a quantidade de horas trabalhadas
    private double salarioLiquido; // Armazena o salário líquido

    public Horista(){ // Construtor passa a função pelo nome da classe e define um valor inicial para a hora
        super.setFuncao(this.getClass().getSimpleName());
        this.valorHora = 10.00;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora() {
        this.valorHora = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da hora (R$): "));
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas() {
        this.horasTrabalhadas = Integer.parseInt(JOptionPane.showInputDialog("Informe as horas trabalhadas: "));

    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(double salarioLiquido) {
        this.salarioLiquido = calcSalario();
    }

    public double calcSalario(){
        return getValorHora() * getHorasTrabalhadas(); // Calcula o salário
    }

    @Override
    public void imprimirHolerite() { // Sobrescreve o método imprimirHolerite da superclasse para si
        super.imprimirHolerite();
        System.out.println("Valor/hora: R$" + valorHora + "\nHoras trabalhadas: " + horasTrabalhadas + "\nSalário Líquido: R$" + salarioLiquido);
    }
}
