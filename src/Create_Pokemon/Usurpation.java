package Create_Pokemon;

import Create_Pokemon.Pokemon;
import Create_Pokemon.Power;
import Players.Joueur;

import java.util.ArrayList;

public class Usurpation extends Power {

    private Pokemon m_possesseur;

    public Usurpation(Pokemon possesseur){
        m_nom = "usurpation";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {
        ArrayList<Pokemon> terrainComplet = new ArrayList<>(adv.getTerrain());
        terrainComplet.addAll(soi.getTerrain());
        String nomCible = adv.choisirPokemon(terrainComplet, "usurper de son pouvoir");
        Pokemon cible = null;
        for (Pokemon p: terrainComplet
             ) {
            if (p.getNom().equals(nomCible)) {
                cible = p;
            }
        }
        m_possesseur.m_pouvoir = cible.getPower();
        m_possesseur.m_pouvoir.m_estUtilisable = true;
        cible.m_pouvoir = null;
    }
}
