/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author vinio
 */
import model.Produto;
import model.Loja;
import javax.jws.WebService;
import javax.jws.WebMethod;
import java.util.List;

@WebService
public interface ServerInterface {

    // PRODUTOS
    @WebMethod Produto criarProduto(Produto p);
    @WebMethod Produto buscarProduto(int id);
    @WebMethod List<Produto> listarProdutos();
    @WebMethod Produto atualizarProduto(Produto p);
    @WebMethod void removerProduto(int id);

    // LOJAS
    @WebMethod Loja criarLoja(Loja l);
    @WebMethod Loja buscarLoja(int id);
    @WebMethod List<Loja> listarLojas();
    @WebMethod Loja atualizarLoja(Loja l);
    @WebMethod void removerLoja(int id);
}
