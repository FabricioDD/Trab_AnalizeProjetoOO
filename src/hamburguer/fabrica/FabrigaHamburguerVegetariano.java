package hamburguer.fabrica;

import hamburguer.modelo.HamburguerVegetariano;

public class FabrigaHamburguerVegetariano extends FabricaHamburguer {

    @Override
    public HamburguerVegetariano criarHamburguer() {

        return new HamburguerVegetariano();

    }

}
