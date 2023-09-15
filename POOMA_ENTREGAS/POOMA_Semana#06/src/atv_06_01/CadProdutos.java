package atv_06_01;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class CadProdutos {
	private ArrayList<Produto> produtos = new ArrayList<>();
	
	public CadProdutos() {
		produtos = new ArrayList<>();
	}
	
	public void adicionar(Produto produto) {
		int id = produtos.size() + 1;
		produto.setId(id);
		produtos.add(produto);
	}
	
	public void remover(int id) {
		int posicao = id - 1;
		produtos.remove(posicao);
		
		for(int i = 0; i < produtos.size(); i++) {
			produtos.get(i).setId(i + 1);
		}
		
		System.out.println("Produto removido.\n");
	}
	
	public void imprimirProduto(int id) {
		int posicao = id - 1;
		produtos.get(posicao).imprimirDados();
	}
	
	public void editar(int id) {
		int posicao = id - 1;
		
		JDialog.setDefaultLookAndFeelDecorated(true);
	    Object[] valores = { "Classificação", "Produto", "Preço" };
	    String valorInicial = "Classificação";
	    Object selecionado = JOptionPane.showInputDialog(null, "O que você deseja editar?",
	        "Edição de produto", JOptionPane.QUESTION_MESSAGE, null, valores, valorInicial);
	    
	    if(selecionado.equals("Classificação")) {
	    	produtos.get(posicao).setClassificacao(Integer.parseInt(JOptionPane.showInputDialog("Informe a nova classificação: ")));
	    }
	    else if(selecionado.equals("Produto")){
	    	produtos.get(posicao).setNome(JOptionPane.showInputDialog("Informe o novo nome: "));
	    }
	    else {
	    	produtos.get(posicao).setPreco(Double.parseDouble(JOptionPane.showInputDialog("Informe o novo preço: ")));
	    }
	    
	    System.out.println("Produto editado: ");
	    produtos.get(posicao).imprimirDados();
	}
	
	public void listarProdutos() {
		for(Produto produto : produtos) {
			produto.imprimirDados();
			System.out.println();
		}
	}
	
	public static void menuProdutos() {
		CadProdutos cadastro = new CadProdutos();
		
		boolean executa = true;
		while(executa == true) {
			JDialog.setDefaultLookAndFeelDecorated(true);
		    Object[] valores = { "Cadastrar produto", "Editar produto", "Remover produto", "Imprimir produto", "Listar produtos cadastrados", "Sair"};
		    String valorInicial = "Cadastrar produto";
		    Object selecionado = JOptionPane.showInputDialog(null, "O que você deseja fazer?",
		        "Gestão de produtos", JOptionPane.QUESTION_MESSAGE, null, valores, valorInicial);
		    
		    if(selecionado.equals("Cadastrar produto")) {
		    	Produto novo = new Produto();
		    	novo.setClassificacao(Integer.parseInt(JOptionPane.showInputDialog("Informe a classificação: ")));
				novo.setNome(JOptionPane.showInputDialog("Informe o nome: "));
				novo.setPreco(Double.parseDouble(JOptionPane.showInputDialog("Informe o preço: ")));
				
				cadastro.adicionar(novo);
				
				System.out.println("Produto cadastrado!\n");
				novo.imprimirDados();
				System.out.println();
		    }
		    else if(selecionado.equals("Editar produto")) {
		    	cadastro.editar(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja editar: ")));
		    }
		    else if(selecionado.equals("Remover produto")) {
		    	cadastro.remover(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja remover: ")));
		    }
		    else if(selecionado.equals("Imprimir produto")) {
		    	cadastro.imprimirProduto(Integer.parseInt(JOptionPane.showInputDialog("Informe o ID do produto que deseja imprimir: ")));
		    }
		    else if(selecionado.equals("Listar produtos cadastrados")) {
		    	cadastro.listarProdutos();
		    }
		    else {
		    	executa = false;
		    	break;
		    }
		}
	}
	
	public static void main(String[] args) {
		menuProdutos();
	}

}
