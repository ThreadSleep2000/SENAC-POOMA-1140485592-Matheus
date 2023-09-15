package atv_06_01;

public class Produto {
	
	// Atributos
	private int id;
	private int classificacao;
	private String nome;
	private double preco;
	
	// Construtores
	public Produto() {}
	
	public Produto(int id, int classificacao, String nome, double preco) {
		this.id = id;
		this.classificacao = classificacao;
		this.nome = nome;
		this.preco = preco;
	}
	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(int classificacao) {
		this.classificacao = classificacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	// Demais métodos
	public void imprimirDados() {
		 System.out.println("Id: " + id + "\nClassificação: " + classificacao + "\nProduto: " + nome + "\nPreço: R$" + preco);
	}

}
