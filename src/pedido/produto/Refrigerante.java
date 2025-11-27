package pedido.produto;

public class Refrigerante implements Produto{
    private double preco;
    private int qtd;

    public Refrigerante(int qtd){
        this.preco = 5;
        this.qtd = qtd;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return "Refrigerante 350 ml";
    }
}
