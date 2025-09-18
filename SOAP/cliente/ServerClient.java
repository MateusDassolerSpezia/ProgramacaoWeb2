package cliente;

import java.net.URL;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;

public class ServerClient {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:9876/loja?wsdl");
		QName qname = new QName("http://controller.project/", "ServerImplService");
		QName PORT_QNAME = new QName("http://controller.project/", "ServerImplPort");

		Service ws = Service.create(url, qname);
		Server controller = ws.getPort(PORT_QNAME, Server.class);
		/*Service ws = Service.create(url, qname);
		Server controller = ws.getPort(Server.class);*/

		try {
			controller.criarLoja(1, "Loja1", "Blumenau");
			controller.create(1, "Produto1", 10.50f, 20.40f, 90);
			controller.create(2, "Produto2", 25.99f, 15, 25);
			System.out.println(controller.readAll());
			System.out.println(controller.readId(2));
			controller.update(1, "Produto2", 10.10f, 15.80f, 75);
			System.out.println(controller.lojaToString());
			System.out.println(controller.delete(3));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
}

/*
 * import javax.xml.namespace.QName; import java.net.URL;
 * 
 * class CalculadoraClient {
 * 
 * public static void main(String args[]) throws Exception { URL url = new
 * URL("http://127.0.0.1:9876/calc?wsdl"); QName qname = new
 * QName("http://calc/","CalculadoraServerImplService"); Service ws =
 * Service.create(url, qname); CalculadoraServer calc =
 * ws.getPort(CalculadoraServer.class);
 * 
 * System.out.println("Soma (5+1): " + calc.soma(5,1));
 * System.out.println("Subtracao (5-1): " + calc.subtracao(5,1));
 * System.out.println("Multiplicacao (5*1): " + calc.multiplicacao(5,1));
 * System.out.println("Divisao (5/1): " + calc.divisao(5,1));
 * 
 * } }
 */