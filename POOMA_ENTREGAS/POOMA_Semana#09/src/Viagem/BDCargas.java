package Viagem;

import Cadastros.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class BDCargas {
    private List<Carga> cargas;

    public BDCargas(){
        cargas = new ArrayList<>();
    }

    public void adicionar(Carga carga){
        cargas.add(carga);
        carga.setNumeracao(cargas.indexOf(carga) + 1);
    }

    public void remover(int numeracao){
        System.out.println("A carga abaixo foi removida.");
        cargas.get(numeracao - 1).exibirCarga();
        cargas.remove(numeracao - 1);
    }

    public int tamanho(){
        return cargas.size();
    }

    public Carga obter(int nro){
        return cargas.get(nro - 1);
    }

    public void listarCargas(){
        System.out.println("\n:::::::: Lista de cargas: ");
        for(Carga carga : cargas){
            carga.exibirCarga();
            System.out.println();
        }
    }
}
