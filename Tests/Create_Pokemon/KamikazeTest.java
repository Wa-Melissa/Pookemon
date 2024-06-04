package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KamikazeTest {
    /**
     * Teste si le pokemon kamikaze est bien placé dans la défausse
     */
    @Test
    public void test_0(){
        Pokemon kamikaze = new Pokemon();
        kamikaze.m_pouvoir = new Kamikaze(kamikaze);

        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);
        ordi2.piocher();
        ordi2.placerPokemon();

        kamikaze.getPower().declencherPouvoir(ordi1,ordi2);

        assertTrue(ordi1.getDefausse().contains(kamikaze));
    }

}