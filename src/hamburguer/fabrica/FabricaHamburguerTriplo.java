package hamburguer.fabrica;

import hamburguer.modelo.Hamburguer;
import hamburguer.modelo.HamburguerTriplo;

public class FabricaHamburguerTriplo extends FabricaHamburguer {

    @Override
    public Hamburguer criarHamburguer() {
        return new HamburguerTriplo();
    }
}
