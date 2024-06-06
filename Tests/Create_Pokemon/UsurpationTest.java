package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsurpationTest {

    /**
     * Test_0 : Teste si Usurpation a bien pris le pouvoir d'un autre pokémon
     */
    @Test
    public void test_0(){
        Pokemon p = new Pokemon();
        p.m_pouvoir = new Usurpation(p);

        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);
        ordi1.piocher();
        ordi1.placerPokemon();

        p.getPower().declencherPouvoir(ordi1,ordi2);

        assertNotNull(p.getPower());

    }
}