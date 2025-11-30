package pedido.produto;

public class BatataFrita implements Produto {
	private double preco;
	private int qtd;

	public BatataFrita(int qtd) {
		this.preco = 15;
		this.qtd = qtd;
	}

	@Override
	public double getPreco() {
		return preco * qtd;
	}

	@Override
	public String getDescricao() {
		return "Batata Frita 400g";
	}
}
