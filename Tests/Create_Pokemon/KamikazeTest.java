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


    /**
     * Teste si le pokemon visé par le kamikaze est bien placé dans la défausse
     */
    @Test
    public void test_1(){
        Pokemon kamikaze = new Pokemon();
        kamikaze.m_pouvoir = new Kamikaze(kamikaze);

        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);
        ordi2.piocher();
        ordi2.placerPokemon();

        ordi2.perdPokemon(ordi2.getTerrain().get(2));
        ordi2.perdPokemon(ordi2.getTerrain().get(1));
        Pokemon cible = ordi2.getTerrain().get(0);

        kamikaze.getPower().declencherPouvoir(ordi1,ordi2);

        assertTrue(ordi2.getDefausse().contains(cible));
    }

}