package pedido.produto;

import java.util.ArrayList;
import java.util.List;

public class CompositeCombo implements Produto {
	private List<Produto> listaProdutos = new ArrayList<>();
	private double descontoPercentual = 0.95;
	private String nomeCombo;

	public CompositeCombo(String nomeCombo) {
		this.nomeCombo = nomeCombo;
	}

	public void adicionarProduto(Produto p) {
		this.listaProdutos.add(p);
	}

	public void removerProduto(Produto p) {
		this.listaProdutos.remove(p);
	}

	@Override
	public double getPreco() {
		double total = 0;
		for (Produto p : listaProdutos) {
			total += p.getPreco();
		}
		return total * descontoPercentual;
	}

	@Override
	public String getDescricao() {
		StringBuilder desc = new StringBuilder();
		desc.append(">>> " + this.nomeCombo + "\n");

		for (Produto p : listaProdutos) {
			String descricaoItem = p.getDescricao();
			desc.append("    |-- " + descricaoItem.replace("\n", "\n    |   ") + "\n");
		}
		return desc.toString();
	}
}