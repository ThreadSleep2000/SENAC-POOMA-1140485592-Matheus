import javax.swing.*;

public class Mensalista extends Funcionario{
    private double valorMes; // Armazena o valor fixo (bruto) por mês

    private double salarioLiquido; // Armazena o salário líquido

    public Mensalista() { // Construtor passa a função pelo nome da classe e define um valor inicial para o salário bruto
        super.setFuncao(this.getClass().getSimpleName());
        this.valorMes = 1200;
    }

    public double getValorMes() {
        return valorMes;
    }

    public void setValorMes() {
        this.valorMes = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor fixo mensal (R$): "));;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido() {
        this.salarioLiquido = getValorMes();
    }

    @Override
    public void imprimirHolerite() { // Sobrescreve o método da superclasse para si
        super.imprimirHolerite();
        System.out.println("Valor/mês: R$" + valorMes + "\nSalário Líquido: R$" + valorMes);
    }
}
