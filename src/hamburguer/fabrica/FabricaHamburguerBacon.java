package hamburguer.fabrica;

import hamburguer.modelo.HamburguerBacon;

public class FabricaHamburguerBacon extends FabricaHamburguer {

    @Override
    public HamburguerBacon criarHamburguer() {

        return new HamburguerBacon();

    }

}
