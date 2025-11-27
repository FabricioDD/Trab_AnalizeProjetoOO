package hamburguer.decorator;

import hamburguer.modelo.Hamburguer;

public class MolhoExtra extends HamburguerDecorator {
    private double precoAdicional = 1;
    private int qtdMolho;

    public MolhoExtra(Hamburguer hamburguer, int qtdMolho) {
        super(hamburguer);
        this.qtdMolho = qtdMolho;
    }

    @Override
    public double getPreco() {
        return hamburguer.getPreco() + (precoAdicional * qtdMolho);
    }

    @Override
    public String getDescricao(){
        return "Hamburguer de " + proteina + " no " + pao + " com " + queijo + " e " + molho + " extra";
    }
}
