package hamburguer.decorator;

import hamburguer.modelo.Hamburguer;

public class CheddarExtra extends HamburguerDecorator {
    private double precoAdicional = 2.5;
    private int qtdCheddar;

    public CheddarExtra(Hamburguer hamburguer, int qtdCheddar) {
        super(hamburguer);
        this.qtdCheddar = qtdCheddar;
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + (precoAdicional * qtdCheddar);
    }

    @Override
    public String getDescricao() {
        return "Hamburguer de " + proteina + " no " + pao + " com " + queijo + " extra e " + molho;
    }
}
