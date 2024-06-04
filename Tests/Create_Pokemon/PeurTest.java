package Create_Pokemon;

import Players.Ordinateur;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PeurTest {
    /**
     * Teste si l'attaque de la cible baisse de 10 points
     */
    @Test
    public void test_0(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        ordi2.piocher();
        ordi2.placerPokemon();
        for (int i = 0 ; i<2 ; i++){
            ordi2.perdPokemon(ordi2.getTerrain().get(i));
        }
        assertEquals(ordi2.getTerrain().size(),1);

        int attaqueInit = ordi2.getTerrain().get(0).m_attaque ;

        Power effrayant = new Peur();
        effrayant.declencherPouvoir(ordi1,ordi2);
        effrayant.finEffetPouvoir();

        assertEquals(ordi2.getTerrain().get(0).m_attaque ,attaqueInit-10);
    }

}