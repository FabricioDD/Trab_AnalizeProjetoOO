package hamburguer.fabrica;

import hamburguer.modelo.HamburguerVegetariano;

public class FabricaHamburguerVegetariano extends FabricaHamburguer {

    @Override
    public HamburguerVegetariano criarHamburguer() {
        return new HamburguerVegetariano();
    }

}