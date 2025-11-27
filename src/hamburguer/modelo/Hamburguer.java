package hamburguer.modelo;

import pedido.produto.Produto;

public abstract class Hamburguer implements Produto {
    protected String pao = "Pão Brioche";
    protected String queijo = "Cheddar";
    protected String molho = "Barbecue Especial";

    protected String proteina;
    protected double preco;

    public Hamburguer(String proteina, double preco) {
        this.proteina = proteina;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    public String getDescricao() {
        return "Hamburguer de " + proteina + " no " + pao + " com " + queijo + " e " + molho;
    }

    public String getProteina() {
        return proteina;
    }
}