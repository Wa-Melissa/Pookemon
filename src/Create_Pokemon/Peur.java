package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Peur extends Power{
    protected Peur(){
        m_nom = "Peur";
        m_estUtilisable = true;
    }

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        Pokemon cible = soi.trouverPokemon(adv.getTerrain(), "effrayer");
        cible.m_attaque -= 10;
        m_estUtilisable = false;

        AffichagePouvoirs.afficherResultatAction(cible.getNom()+" a été effrayé !");
    }
}
