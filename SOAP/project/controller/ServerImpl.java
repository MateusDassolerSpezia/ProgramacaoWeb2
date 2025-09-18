package project.controller;

import javax.jws.WebService;

import project.model.Produto;
import project.model.Loja;

@WebService(endpointInterface = "project.controller.Server")
public class ServerImpl implements Server {

	private Loja loja;	

	@Override
	public void create(int id, String nome, float preco, float custo, int quantidade) throws IllegalArgumentException{
		if (this.loja == null) {
			throw new IllegalArgumentException("Loja não pode ser nula");
		}
		loja.create(new Produto(id, nome, preco, custo, quantidade));
	}

	@Override
	public String readAll() {
		return loja.readAll();
	}

	@Override
	public String readId(int id) {
		return loja.readId(id);
	}

	@Override
	public Produto update(int id, String nome, float preco, float custo, int quantidade) throws IllegalArgumentException {
		if (this.loja == null) {
			throw new IllegalArgumentException("Loja não pode ser nula");
		}
		return loja.update(id, new Produto(id, nome, preco, custo, quantidade));
	}

	@Override
	public boolean delete(int id) {
		return loja.delete(id);
	}

	@Override
	public void criarLoja(int id, String nome, String endereco) {
		loja = new Loja(id, nome, endereco);
	}

	@Override
	public String lojaToString() throws IllegalArgumentException{
		if (this.loja == null) {
			throw new IllegalArgumentException("Loja não pode ser nula");
		}
		return loja.toString();
	}
	
}
