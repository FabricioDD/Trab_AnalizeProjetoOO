package pedido.produto;

import java.util.ArrayList;

public class CompositeCombo implements Produto{
    private ArrayList<Produto> listaProdutos = new ArrayList<>();
    private double descontoPercentual;
    private double preco;

    public void adiconarProduto(Produto produto){

    }

    public void removerProduto(Produto produto){

    }

    @Override
    public double getPreco() {
        return preco;
    }
}
