package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

import java.util.ArrayList;

public class Usurpation extends Power {

    private final Pokemon m_possesseur;

    protected Usurpation(Pokemon possesseur){
        m_nom = "usurpation";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        ArrayList<Pokemon> terrainComplet = new ArrayList<>(adv.getTerrain());
        terrainComplet.addAll(soi.getTerrain());
        Pokemon cible = soi.trouverPokemon(terrainComplet, "usurper de son pouvoir");
        if (cible.m_pouvoir != null){
            m_possesseur.m_pouvoir = cible.m_pouvoir;
            m_possesseur.m_pouvoir.m_estUtilisable = true;
            AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a pris le pouvoir "+m_possesseur.m_pouvoir.getNom()+" de "+cible.getNom());

        }else {
            m_possesseur.m_pouvoir = null;
            AffichagePouvoirs.afficherResultatAction(cible.getNom()+" n'avait pas de pouvoir ! "+m_possesseur.getNom()+" a perdu son pouvoir");
        }
        cible.m_pouvoir = null;

        m_estUtilisable = false;
    }

    @Override
    public String toString(){
        return super.toString() + " C'est le pokémon "+m_possesseur.getNom()+" qui possède ce pouvoir.";
    }
}
