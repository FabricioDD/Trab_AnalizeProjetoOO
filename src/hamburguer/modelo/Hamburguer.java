package hamburguer.modelo;

import pedido.produto.Produto;

public abstract class Hamburguer implements Produto {
    protected String tipo;
    protected double preco;

    public Hamburguer(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return "Hamburguer de " + tipo;
    }

    public String getTipo() {
        return tipo;
    }
}