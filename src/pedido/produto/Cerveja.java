package pedido.produto;

public class Cerveja implements Produto{
    private double preco;
    private int qtd;

    public Cerveja(int qtd){
        this.preco = 12.5;
        this.qtd = qtd;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getDescricao() {
        return "Cerveja long neck 600ml";
    }
}
