package Cadastros;

import java.util.ArrayList;
import java.util.List;

public class BDVeiculos {
    private List<Veiculo> veiculos;

    public BDVeiculos(){
        veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo){
        veiculos.add(veiculo);
    }

    public int tamanho(){
        return veiculos.size();
    }

    public Veiculo obter(String placa){
        for(Veiculo veiculo : veiculos){
            if(placa.equalsIgnoreCase(veiculo.getPlaca())){
                return veiculo;
            }
        }
        System.out.println("Veículo não cadastrado.");
        return null;
    }

    public void listarVeiculos(){
        System.out.println("\n:::::::: Lista de veículos: ");
        for(Veiculo veiculo : veiculos){
            System.out.println(veiculo.toString() + "\n");
        }
    }
}
