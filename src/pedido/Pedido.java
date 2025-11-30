package pedido;

import cliente.Cliente;
import pedido.pagamento.EstrategiaPagamento;
import pedido.produto.Produto;

import java.util.ArrayList;

public class Pedido {
	private Cliente cliente;
	private ArrayList<Produto> listaProdutos = new ArrayList();
	private EstrategiaPagamento metodoPagamento;
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	public void adicionarProduto(Produto p) {
		listaProdutos.add(p);
	}

	public void removerProduto(Produto p) {
		listaProdutos.remove(p);
	}

	public double calculaValorTotal() {
		double total = 0;

		for (Produto p : listaProdutos) {
			total += p.getPreco();
		}
		return total;
	}

	public void setEstrategiaPagamento(EstrategiaPagamento ep) {
		metodoPagamento = ep;
	}

	public void exibirInfoPedido() {
		System.out.println("\n==========================================");
		System.out.println("              CUPOM DO PEDIDO             ");
		System.out.println("==========================================");
		System.out.printf("CLIENTE: %s\n", cliente.getNome().toUpperCase());
		System.out.println("------------------------------------------");
		System.out.println("DESCRIÇÃO");
		System.out.println("------------------------------------------");

		for (Produto p : listaProdutos) {
			System.out.println("  " + p.getDescricao());
		}

		System.out.println("------------------------------------------");

		System.out.printf("TOTAL A PAGAR .................... R$ %6.2f\n", calculaValorTotal());

		System.out.println("==========================================");
		System.out.println("        OBRIGADO PELA PREFERENCIA!        ");
		System.out.println("==========================================\n");
	}

	public void finalizarPedido() {
		double valor = calculaValorTotal();
		metodoPagamento.pagar(valor);
	}
}
