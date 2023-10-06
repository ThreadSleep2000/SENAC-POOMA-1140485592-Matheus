import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CadFuncionario {
    private List<Funcionario> funcionarios;

    public CadFuncionario() {funcionarios = new ArrayList<>();}

    public void adicionar(Funcionario funcionario) {funcionarios.add(funcionario);}

    public void listarFuncionarios(){
        for(Funcionario funcionario : funcionarios){
            funcionario.imprimirHolerite();
            System.out.println();
        }
    }

    public static void main(String[] args) {
        CadFuncionario cadastro = new CadFuncionario();

        String[] opcoes = {"Horista", "Tarefeiro", "Mensalista"};

        int escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção: ", "Menu de seleção", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        switch(escolha){
            case 0:
                Horista hora = new Horista();
                hora.setNome();
                hora.setDepto();
                hora.setHorasTrabalhadas();
                hora.setValorHora();
                hora.setSalarioLiquido(hora.calcSalario());
                cadastro.adicionar(hora);
                break;
            case 1:
                Tarefeiro tarefa = new Tarefeiro();
                tarefa.setNome();
                tarefa.setDepto();
                tarefa.setTarefasConcluidas();
                tarefa.setValorTarefa();
                tarefa.setSalarioLiquido(tarefa.calcSalario());
                cadastro.adicionar(tarefa);
                break;
            case 2:
                Mensalista mensal = new Mensalista();
                mensal.setNome();
                mensal.setDepto();
                mensal.setValorMes();
                cadastro.adicionar(mensal);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }

        cadastro.listarFuncionarios();

    }
}
