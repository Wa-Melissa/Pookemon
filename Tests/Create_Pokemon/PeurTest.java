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

        int attaqueInit = ordi2.getTerrain().get(0).m_attaque ;

        Power effrayant = new Peur();
        effrayant.declencherPouvoir(ordi1,ordi2);
        effrayant.finEffetPouvoir();

        assertEquals(ordi2.getTerrain().get(0).m_attaque ,attaqueInit-10);
    }

    /**
     * Vérifie que la valeure d'une attaque ne peut pas être négative meme si un pokemon cumule une attaque basse et un désavantage avec peur
     */
    @Test
    public void test_1(){
        Ordinateur ordi1 = new Ordinateur("",true);
        Ordinateur ordi2 = new Ordinateur("",false);

        ordi1.piocher();
        ordi1.placerPokemon();
        ordi2.piocher();
        ordi2.placerPokemon();

        ordi2.perdPokemon(ordi2.getTerrain().get(2));
        ordi2.perdPokemon(ordi2.getTerrain().get(1)); // On ne garde qu'un pokemon pour etre sur que le pouvoir se déclenche sur lui
        ordi2.getTerrain().get(0).m_attaque = 10; // on s'assure que l'attaque est à 10

        Power fantome = new Peur();
        fantome.declencherPouvoir(ordi1,ordi2);

        ordi1.perdPokemon(ordi1.getTerrain().get(2));
        ordi1.perdPokemon(ordi1.getTerrain().get(1));

        Pokemon pokemon1 = ordi1.getTerrain().get(0);
        Pokemon pokemon2 = ordi2.getTerrain().get(0);

        pokemon1.m_element = new Element("Eau"); //On donne un désavantage au pokemon qui a peur
        pokemon2.m_element = new Element("Feu");

        int pvInit = pokemon1.getPV() ;
        pokemon2.attaque(pokemon1,ordi1);
        assertEquals(pokemon1.getPV(),pvInit);
    }

}