package Viagem;

import Cadastros.Veiculo;

import java.util.ArrayList;
import java.util.List;

public class BDEmissor {
    private List<Emissor> documentos;

    public BDEmissor(){
        documentos = new ArrayList<>();
    }

    public void adicionar(Emissor documento){
        documentos.add(documento);
        documento.setNumeracao(documentos.indexOf(documento) + 1);
    }

    public void listarDocumentos(){
        System.out.println("\n:::::::: Lista de documentos: ");
        for(Emissor documento : documentos){
            documento.imprimirDocumentacao();
            System.out.println();
        }
    }
}
