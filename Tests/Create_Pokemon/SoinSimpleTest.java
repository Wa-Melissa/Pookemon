package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoinSimpleTest {
    /**
     * Vérifie que la vie du pokemon soigné ne dépasse pas ses pv max
     */
    @Test
public void test_0(){
    Ordinateur ordi1 = new Ordinateur("",true);
    Ordinateur ordi2 = new Ordinateur("",false);

    ordi1.piocher();
    ordi1.placerPokemon();
    for (int i = 0 ; i<2 ; i++){
        ordi1.perdPokemon(ordi1.getTerrain().get(i));
    }
    assertEquals(ordi1.getTerrain().size(),1);
    int vieInit = ordi1.getTerrain().get(0).m_pv ;

    Power soin = new SoinSimple();
    soin.declencherPouvoir(ordi1,ordi2);

    assertEquals(ordi1.getTerrain().get(0).m_pv , vieInit);
    }
}