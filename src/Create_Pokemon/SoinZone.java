package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class SoinZone extends Power {
    protected SoinZone(){
        m_nom = "soin de zone";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        for (int i = 0 ; i < soi.getTerrain().size() ; i++){
            soi.getTerrain().get(i).estSoigne(10);
        }

        AffichagePouvoirs.afficherResultatAction("tous vos pokemons ont récupéré de la santé !");

    }
}
