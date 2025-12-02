package hamburguer.decorator;

import hamburguer.modelo.Hamburguer;

public abstract class HamburguerDecorator extends Hamburguer {
    public Hamburguer hamburguer;

    public HamburguerDecorator(Hamburguer hamburguer) {
        super(hamburguer.getTipo(), hamburguer.getPreco());
        this.hamburguer = hamburguer;
    }

    @Override
    public abstract double getPreco();
}
