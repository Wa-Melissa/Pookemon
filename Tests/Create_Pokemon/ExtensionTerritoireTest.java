package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExtensionTerritoireTest {
    /**
     * Teste si il y a un pokemon qui est ajouté sur le terrain
     */
    @Test
    public void test_0(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        Pokemon sukuna = new Pokemon();
        sukuna.m_pouvoir = new ExtensionTerritoire();

        ordi1.piocher();
        ordi1.placerPokemon();

        sukuna.getPower().declencherPouvoir(ordi1,ordi2);
        assertEquals(ordi1.getTerrain().size(),4);
    }


    /**
     * Teste si tout se passe bien si le pouvoir extension du territoire est utilisé 2 fois (régénéré)
     */
    @Test
    public void test_1(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        Pokemon sukuna = new Pokemon();
        sukuna.m_pouvoir = new ExtensionTerritoire();

        ordi1.piocher();
        ordi1.placerPokemon();

        sukuna.getPower().declencherPouvoir(ordi1,ordi2);

        sukuna.getPower().m_estUtilisable = true;

        sukuna.getPower().declencherPouvoir(ordi1,ordi2);
        assertEquals(ordi1.getTerrain().size(),5);
    }
}