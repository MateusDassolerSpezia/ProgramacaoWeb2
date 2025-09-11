package project.model;

public class Produto {

	private int id;
	private String nome;
	private float preco;
	private float custo;
	private int quantidade;

	public Produto(int id, String nome, float preco, float custo, int quantidade) {
		super();
		setId(id);
		setNome(nome);
		setPreco(preco);
		setCusto(custo);
		setQuantidade(quantidade);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("O id deve ser maior do que zero!");
		}
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser vazio!");
		}
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		if (preco < 0) {
			throw new IllegalArgumentException("O preço não pode ser menor que zero!");
		}
		this.preco = preco;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		if (custo < 0) {
			throw new IllegalArgumentException("O custo não pode ser menor que zero!");
		}
		this.custo = custo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		if (quantidade < 0) {
			throw new IllegalArgumentException("A quantidade não pode ser menor que zero!");
		}
		this.quantidade = quantidade;
	}
	
	public String toString() {
		return(getNome() + " qtd: " + getQuantidade() + " +R$" + getPreco() + " -R$" + getCusto());
	}
}
