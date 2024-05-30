package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Peur extends Power{
    protected Peur(){
        m_nom = "Peur";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        Pokemon cible = soi.trouverPokemon(adv.getTerrain(), "effrayer");
        cible.m_attaque -= 10;
        m_estUtilisable = false;

        AffichagePouvoirs.afficherResultatAction("Vous avez effrayé "+cible.getNom()+" !");
    }
}
