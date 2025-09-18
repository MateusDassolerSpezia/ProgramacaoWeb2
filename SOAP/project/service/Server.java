/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author vinio
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import project.model.Produto;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Server {
	@WebMethod void criarLoja(int id, String nome, String endereco);
	@WebMethod void create(int id, String nome, float preco, float custo, int quantidade);
	@WebMethod String readAll();
	@WebMethod String ReadId(int id);
	@WebMethod Produto update(int id, String nome, float preco, float custo, int quantidade);
	@WebMethod boolean delete(int id);
	@WebMethod String lojaToString();
}