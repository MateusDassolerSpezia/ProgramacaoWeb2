package cliente;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface Server {
	@WebMethod void criarLoja(int id, String nome, String endereco);
	@WebMethod void create(int id, String nome, float preco, float custo, int quantidade);
	@WebMethod String readAll();
	@WebMethod String readId(int id);
	@WebMethod Produto update(int id, String nome, float preco, float custo, int quantidade);
	@WebMethod boolean delete(int id);
	@WebMethod String lojaToString();
}
