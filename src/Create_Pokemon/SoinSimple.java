package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class SoinSimple extends Power {

    protected SoinSimple(){
        m_nom = "soin simple";
        m_estUtilisable = true;
    }


    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        Pokemon receveur = soi.trouverPokemon(soi.getTerrain(), "soigner");
        receveur.estSoigne(30);

        AffichagePouvoirs.afficherResultatAction(receveur.getNom() +" s'est régénéré !");
    }

}
