package application.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "lojas")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_loja")
	private int id;
	
	@Column(name = "nm_loja", nullable = false)
	private String nome;
	
	@Column(name = "ds_loja")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "cd_loja")
	private List<Produto> listaProdutos;

	public Loja() {
		super();
		listaProdutos = new ArrayList<Produto>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		/*if (descricao.isBlank()) {
			throw new IllegalArgumentException("A descrição não pode ser vazio!");
		}*/
		this.descricao = descricao;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}
	
	public void addProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
}