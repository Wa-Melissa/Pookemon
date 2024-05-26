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
        String nomReceveur = soi.choisirPokemon(soi.getTerrain(), "soigner");
        int j = 0;
        while(!soi.getTerrain().get(j).getNom().equals(nomReceveur)){
            j++;
        }
        Pokemon receveur = (soi.getTerrain().get(j));
        receveur.estSoigne(30);

        AffichagePouvoirs.afficherResultatAction(nomReceveur+" s'est régénéré !");
    }

}
