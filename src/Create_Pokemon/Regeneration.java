package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Regeneration extends Power{

    public final Pokemon m_possesseur;

    protected Regeneration(Pokemon possesseur)
    {
        m_nom = "Regeneration";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv)
    {
        this.m_estUtilisable = false;
        Pokemon cible = soi.trouverPokemon(soi.getTerrain(), "regenerer le pouvoir");
        if (cible.m_pouvoir != null){
            cible.getPower().m_estUtilisable = true;
            AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a régénéré le pouvoir de "+cible.getNom()+" !");
        }else {
            AffichagePouvoirs.afficherResultatAction(cible.getNom()+" n'avait pas de pouvoir ! ");
        }
    }
}
