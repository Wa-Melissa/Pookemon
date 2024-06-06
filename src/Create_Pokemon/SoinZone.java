package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class SoinZone extends Power {
    protected SoinZone(){
        m_nom = "Soin de zone";
        m_estUtilisable = true;
    }

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        for (int i = 0 ; i < soi.getTerrain().size() ; i++){
            soi.getTerrain().get(i).estSoigne(10);
        }

        AffichagePouvoirs.afficherResultatAction("tous les pokemons de "+soi.getPseudo()+" ont récupéré de la santé !");

    }
}
