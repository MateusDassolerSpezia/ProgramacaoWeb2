package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cd_produto")
	private int id;
	
	@Column(name = "nm_produto")
	private String nome;
	
	@Column(name = "ds_produto")
	private String descricao;
	
	@Column(name = "vl_venda")
	private Float valorVenda;
	
	@Column(name = "vl_custo")
	private Float valorCusto;
	
	@Column(name = "qt_estoque")
	private Integer estoque;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id <= 0 ) {
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
		if (descricao.isBlank()) {
			throw new IllegalArgumentException("A descrição não pode ser vazio!");
		}
		this.descricao = descricao;
	}

	public Float getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Float valorVenda) {
		if (valorVenda < 0) {
			throw new IllegalArgumentException("O preço não pode ser menor que zero!");
		}
		this.valorVenda = valorVenda;
	}

	public Float getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(Float valorCusto) {
		if (valorCusto < 0) {
			throw new IllegalArgumentException("O custo não pode ser menor que zero!");
		}
		this.valorCusto = valorCusto;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		if (estoque < 0) {
			throw new IllegalArgumentException("A quantidade não pode ser menor que zero!");
		}
		this.estoque = estoque;
	}
}