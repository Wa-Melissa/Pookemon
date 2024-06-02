package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class SoinSimple extends Power {

    protected SoinSimple(){
        m_nom = "Soin simple";
        m_estUtilisable = true;
    }


    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        Pokemon receveur = soi.trouverPokemon(soi.getTerrain(), "soigner");
        receveur.estSoigne(30);

        AffichagePouvoirs.afficherResultatAction(receveur.getNom() +" s'est régénéré !");
    }

}
