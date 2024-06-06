package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class BerserkTest {

    /**
     * Teste si la méthode de fin d'effet du pouvoir fonctionne et ramène le pokemon a ses stats d'attaque initiales
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
        int attaqueInit = ordi1.getTerrain().get(0).m_attaque ;

        Power berserk = new Berserk();
        berserk.declencherPouvoir(ordi1,ordi2);
        berserk.finEffetPouvoir();

        assertEquals(ordi1.getTerrain().get(0).m_attaque ,attaqueInit);
    }


    /**
     * Teste l'augmentation de l'attaque
     */
    @Test
    public void test_1(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        ordi1.piocher();
        ordi1.placerPokemon();
        for (int i = 0 ; i<2 ; i++){
            ordi1.perdPokemon(ordi1.getTerrain().get(i));
        }
        int attaqueInit = ordi1.getTerrain().get(0).m_attaque ;

        Power berserk = new Berserk();
        berserk.declencherPouvoir(ordi1,ordi2);

        assertEquals(ordi1.getTerrain().get(0).m_attaque ,attaqueInit*2);
    }

}