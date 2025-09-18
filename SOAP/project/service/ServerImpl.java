/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author vinio
 */
import javax.jws.WebService;
import project.model.Produto;
import project.model.Loja;

@WebService(endpointInterface = "calc.CalculadoraServer")
public class ServerImpl implements Server {

	private Loja loja;	
	
	@Override
	public void create(int id, String nome, float preco, float custo, int quantidade) {
		loja.create(new Produto(id, nome, preco, custo, quantidade));
	}

	@Override
	public String readAll() {
		return loja.readAll();
	}

	@Override
	public String ReadId(int id) {
		return loja.readId(id);
	}

	@Override
	public Produto update(int id, String nome, float preco, float custo, int quantidade) {
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
	public String lojaToString() {
		return loja.toString();
	}
	
}