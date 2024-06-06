package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegenerationTest {
    /**
     * Teste si le pouvoir devient unitilisable après avoir été utilisé
     */
    @Test
    public void test_0(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        ordi1.piocher();
        ordi1.placerPokemon();
        ordi2.piocher();
        ordi2.placerPokemon();

        Power vacances = new Regeneration();

        vacances.declencherPouvoir(ordi1,ordi2);
        assertFalse(vacances.isUtilisable());
    }

    /**
     * Teste si le pouvoir régénéré redevient utilisable
     */
    @Test
    public void test_1(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        ordi2.piocher();
        ordi2.placerPokemon();

        ordi2.perdPokemon(ordi2.getTerrain().get(2));
        ordi2.perdPokemon(ordi2.getTerrain().get(1));
        Pokemon p = ordi2.getTerrain().get(0);
        p.m_pouvoir = new Berserk();
        p.getPower().m_estUtilisable = false;

        Power vacances = new Regeneration();
        vacances.declencherPouvoir(ordi2,ordi1);

        assertTrue(p.getPower().isUtilisable());
    }

}