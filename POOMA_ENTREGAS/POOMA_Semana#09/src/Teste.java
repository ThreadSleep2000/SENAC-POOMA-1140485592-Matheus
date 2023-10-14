import Cadastros.*;
import Viagem.BDCargas;
import Viagem.BDEmissor;
import Viagem.Carga;
import Viagem.Emissor;

import javax.swing.*;

public class Teste {
    public static void main(String[] args) {
        BDCadastros cadPessoas = new BDCadastros<>();
        BDVeiculos cadVeiculos = new BDVeiculos();
        BDCargas cadCargas = new BDCargas();
        BDEmissor cadDocumentos = new BDEmissor();

        menuSelecao(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
    }

    public static void menuSelecao(BDCadastros cadPessoas, BDVeiculos cadVeiculos, BDCargas cadCargas, BDEmissor cadDocumentos) {

        String[] opcoes = {"Cadastros", "Carga", "Documentação", "Listas", "Sair"};

        int escolha = -1; // Inicialize a escolha com um valor inválido

        while (escolha != 4) { // 4 representa a opção "Sair"
            escolha = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Menu de Seleção",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (escolha == 0) {
                menuCadastroOpcoes(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);

            } else if (escolha == 1) {
                if(cadPessoas.tamanho() < 3){
                    System.out.println("Cadastre ao menos 3 pessoas primeiro!");
                } else {
                    Cliente remetente = (Cliente) cadPessoas.obter(JOptionPane.showInputDialog("Informe o doc. do remetente: "));
                    Cliente destinatario = (Cliente) cadPessoas.obter(JOptionPane.showInputDialog("Informe o doc. do destinatario: "));
                    Cliente tomador = (Cliente) cadPessoas.obter(JOptionPane.showInputDialog("Informe o doc. do tomador: "));

                    Carga carga = new Carga(remetente, destinatario, tomador);
                    carga.setValorFrete();
                    carga.setMercadoria();
                    carga.setNotas();
                    carga.setDataColeta();
                    carga.setDataEntrega();
                    carga.setMotorista((Motorista) cadPessoas.obter(JOptionPane.showInputDialog("Informe o doc. do motorista: ")));

                    if (cadVeiculos.tamanho() == 0) {
                        System.out.println("Cadastre um veículo primeiro!");
                    } else {
                        carga.setVeiculo(cadVeiculos.obter(JOptionPane.showInputDialog("Informe a placa do veículo: ")));
                    }
                    cadCargas.adicionar(carga);
                    carga.exibirCarga();
                }
            } else if (escolha == 2) {
                if(cadCargas.tamanho() == 0){
                    System.out.println("Cadastre uma carga primeiro!\n");
                } else {
                    Emissor documento = new Emissor(cadCargas.obter(Integer.parseInt(JOptionPane.showInputDialog("Informe o número da carga: "))));
                    cadDocumentos.adicionar(documento);

                    documento.imprimirDocumentacao();
                }
            } else if (escolha == 3) {
                menuSelecaoLista(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
            } else if (escolha == 4) {
                JOptionPane.showMessageDialog(null, "Saindo do menu de seleção");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
            }
        }
    }

    public static void menuCadastroOpcoes(BDCadastros cadPessoas, BDVeiculos cadVeiculos, BDCargas cadCargas, BDEmissor cadDocumentos) {
        String[] opcoes = {"Cadastrar", "Excluir pessoas", "Voltar"};

        int escolha = -1; // Inicialize a escolha com um valor inválido

        while (escolha != 2) { // 2 representa a opção "Voltar"
            escolha = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Menu de seleção de ação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (escolha == 0) {
                menuSelecaoCadastro(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
            } else if (escolha == 1) {
                String chave = JOptionPane.showInputDialog("Informe o CPF/CNPJ para ser excluído: ");
                cadPessoas.remover(chave);
            } else if (escolha == 2) {
                JOptionPane.showMessageDialog(null, "Voltando ao menu de seleção");
                menuSelecao(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
            }
        }
    }
    public static void menuSelecaoCadastro(BDCadastros cadPessoas, BDVeiculos cadVeiculos, BDCargas cadCargas, BDEmissor cadDocumentos) {
        String[] opcoes = {"Cliente", "Motorista", "Proprietário", "Veículo", "Voltar"};
        int escolha = -1; // Inicialize a escolha com um valor inválido

        while (escolha != 4) { // 3 representa a opção "Sair"
            escolha = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Menu de seleção de cadastro",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (escolha == 0) {
                Cliente cliente = new Cliente();
                cadPessoas.adicionar(cliente);

                System.out.println(cliente.toString());
            } else if (escolha == 1) {
                Motorista motorista = new Motorista();
                cadPessoas.adicionar(motorista);

                System.out.println(motorista.toString());
            } else if (escolha == 2) {
                Proprietario proprietario = new Proprietario();
                cadPessoas.adicionar(proprietario);

                System.out.println(proprietario.toString());
            } else if (escolha == 3){
                Veiculo veiculo = new Veiculo();
                String documento = JOptionPane.showInputDialog("Informe o documento (CPF/CNPJ) do proprietário: ");
                Proprietario prop = (Proprietario) cadPessoas.obter(documento);
                if(prop != null){
                    veiculo.setProprietario(prop);
                }else{
                    System.out.println("Veículo cadastrado sem proprietário.");
                }
                cadVeiculos.adicionar(veiculo);

                System.out.println(veiculo.toString());
            } else if (escolha == 4) {
                JOptionPane.showMessageDialog(null, "Voltando ao menu de seleção");
                menuSelecao(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
            }
        }
    }

    public static void menuSelecaoLista(BDCadastros cadPessoas, BDVeiculos cadVeiculos, BDCargas cadCargas, BDEmissor cadDocumentos) {
        String[] opcoes = {"Pessoas", "Veículos", "Cargas", "Documentos", "Voltar"};
        int escolha = -1; // Inicialize a escolha com um valor inválido

        while (escolha != 4) { // 4 representa a opção "Sair"
            escolha = JOptionPane.showOptionDialog(null,
                    "Escolha uma opção:",
                    "Menu de seleção de listagem",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]);

            if (escolha == 0) {
                cadPessoas.listarPessoas();
            } else if (escolha == 1) {
                cadVeiculos.listarVeiculos();
            } else if (escolha == 2) {
                cadCargas.listarCargas();
            } else if (escolha == 3) {
                cadDocumentos.listarDocumentos();
            } else if (escolha == 4) {
                JOptionPane.showMessageDialog(null, "Voltando ao menu de seleção");
                menuSelecao(cadPessoas, cadVeiculos, cadCargas, cadDocumentos);
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma opção selecionada");
            }
        }
    }
}