package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoinZoneTest {
    /**
     * verifie que tous les pokemons du terrain regagnent 10 pv
     */
    @Test
    public void test_0(){
        Ordinateur ordi1 = new Ordinateur("pseudo1",true);
        Ordinateur ordi2 = new Ordinateur("pseudo2",false);

        ordi1.piocher();
        ordi1.placerPokemon();
        for (int i = 0 ; i<3 ; i++){
            ordi1.getTerrain().get(i).m_pv -= 15;
        }

        Power hopital = new SoinZone();
        hopital.declencherPouvoir(ordi1,ordi2);

        assertEquals(ordi1.getTerrain().get(0).m_pvMax-5,ordi1.getTerrain().get(0).m_pv);
        assertEquals(ordi1.getTerrain().get(1).m_pvMax-5,ordi1.getTerrain().get(1).m_pv);
        assertEquals(ordi1.getTerrain().get(2).m_pvMax-5,ordi1.getTerrain().get(2).m_pv);

    }

    /**
     * Vérifie que le pouvoir reste utilisable
     */
    @Test
    public void test_1(){
        Ordinateur ordi1 = new Ordinateur("pseudo1",true);
        Ordinateur ordi2 = new Ordinateur("pseudo2",false);

        Power hopital = new SoinZone();

        hopital.declencherPouvoir(ordi1,ordi2);
        assertTrue(hopital.isUtilisable());
    }
}