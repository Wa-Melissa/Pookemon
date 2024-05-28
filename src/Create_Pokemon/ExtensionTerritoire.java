package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class ExtensionTerritoire extends Power {

    protected ExtensionTerritoire(){
        m_nom = "extension du territoire";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        soi.piocher();
        if (!soi.getMain().isEmpty()){
            Pokemon nouveau = soi.trouverPokemon(soi.getMain(), "ajouter au terrain");
            soi.bougerPokemon(nouveau.getNom(),soi.getMain(), soi.getTerrain());
            m_estUtilisable = false;

            AffichagePouvoirs.afficherResultatAction(nouveau.getNom()+" a été ajouté au terrain !");
        }
        else {
            AffichagePouvoirs.afficherResultatAction("Oups! la pioche est vide!");
        }
    }
}
