package tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.LojaController;
import controller.ProdutoController;
import model.Loja;
import model.Produto;

public class Teste01 {

	public static void main(String... args) {
		
		  /*
		  Loja loja = new Loja();
		  loja.setNome("Loja 1");
		  loja.setDescricao("Descrição da loja 1");
		  
		  Produto p1 = new Produto();
		  p1.setNome("Produto 1");
		  p1.setDescricao("Produto descritivo 1");
		  p1.setValorCusto(5.0f);
		  p1.setValorVenda(10.5f);
		  p1.setEstoque(27);
		  
		  Produto p2 = new Produto();
		  p2.setNome("Produto 2");
		  p2.setDescricao("Descrição produto 2");
		  p2.setValorCusto(8.25f);
		  p2.setValorVenda(15.99f);
		  p2.setEstoque(33);
		  
		  loja.addProduto(p1);
		  loja.addProduto(p2);
		  */
		 
		LojaController lojaCtrl = new LojaController();
        ProdutoController prodCtrl = new ProdutoController();
        /*
        Loja loja = new Loja();
        loja.setNome("Loja 3");
        loja.setDescricao("Loja de testes 3");

        Produto p = new Produto();
        p.setNome("Café");
        p.setDescricao("Café torrado");
        p.setValorVenda(12.5f);
        p.setValorCusto(8.0f);
        p.setEstoque(50);

        loja.addProduto(p);
        
        lojaCtrl.inserir(loja);
        
        for (Produto prod : prodCtrl.listar()) {
            System.out.println(prod.getNome());
        }*/
		
        prodCtrl.deletar(3);
        
        prodCtrl.atualizar(null);
	}
}
