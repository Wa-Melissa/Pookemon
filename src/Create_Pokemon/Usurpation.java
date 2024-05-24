package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

import java.util.ArrayList;

public class Usurpation extends Power {

    private final Pokemon m_possesseur;

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
        if (cible.m_pouvoir != null){
            m_possesseur.m_pouvoir = cible.m_pouvoir;
            m_possesseur.m_pouvoir.m_estUtilisable = true;
            AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a pris le pouvoir "+m_possesseur.m_pouvoir.getNom()+" de "+cible.getNom());

        }else {
            m_possesseur.m_pouvoir = null;
            AffichagePouvoirs.afficherResultatAction(cible.getNom()+" n'avait pas de pouvoir ! "+m_possesseur+" a perdu son pouvoir");
        }
        cible.m_pouvoir = null;

        m_estUtilisable = false;
    }
}
