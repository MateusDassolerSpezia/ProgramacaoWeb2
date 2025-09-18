package cliente;
import java.util.ArrayList;

public class Loja {

	private int id;
	private String nome;
	private String endereco;
	private ArrayList<Produto> listaProdutos;

	public Loja(int id, String nome, String endereco) {
		super();
		setId(id);
		setNome(nome);
		setEndereco(endereco);
		listaProdutos = new ArrayList<Produto>();
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco.isBlank()) {
			throw new IllegalArgumentException("O endereço não pode ser vazio!");
		}
		this.endereco = endereco;
	}

	public ArrayList<Produto> getProdutos() {
		return listaProdutos;
	}

	public void create(Produto produto) {
		listaProdutos.add(produto);
	}

	public String readAll() {
		String produtos = "";
		for (Produto p : listaProdutos) {
			produtos += p.toString() + "\n";
		}
		return produtos;
	}

	public String readId(int id) {
		String produtos = "";
		for (Produto p : listaProdutos) {
			if (p.getId() == id) {
				produtos += p.toString() + "\n";
			}
		}
		return produtos;
	}

	private Produto buscar(int id) {
		for (Produto p : listaProdutos) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public Produto update(int id, Produto novo) {
		Produto p = buscar(id);
		if (p == null) {
			return null;
		}
		p.setNome(novo.getNome());
		p.setPreco(novo.getPreco());
		p.setCusto(novo.getCusto());
		p.setQuantidade(novo.getQuantidade());
		return p;
	}

	public boolean delete(int id) {
		Produto p = buscar(id);
		if (p == null) {
			return false;
		}
		listaProdutos.remove(p);
		return true;
	}

	public String toString() {
		return ("Loja: " + getNome() + " | " + getEndereco() + "\n" + readAll());
	}
}
