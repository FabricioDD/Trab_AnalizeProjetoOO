package hamburguer.decorator;

import hamburguer.modelo.Hamburguer;

public abstract class HamburguerDecorator extends Hamburguer {
    public Hamburguer hamburguer;

    public HamburguerDecorator(Hamburguer hamburguer) {
        super(hamburguer.getProteina(), hamburguer.getPreco());
        this.hamburguer = hamburguer;
    }

    public abstract double getPreco();
}
