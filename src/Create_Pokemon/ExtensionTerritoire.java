package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Affichage.Affichage_Plateau;
import Players.Joueur;

public class ExtensionTerritoire extends Power {

    protected ExtensionTerritoire(){
        m_nom = "Extension du territoire";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        soi.piocher();
        if (!soi.getMain().isEmpty()){
            Affichage_Plateau p = new Affichage_Plateau();
            p.afficherMain(soi);
            Pokemon nouveau = soi.trouverPokemon(soi.getMain(), "ajouter au terrain");
            soi.bougerPokemon(nouveau.getNom(),soi.getMain(), soi.getTerrain());
            m_estUtilisable = false;

            AffichagePouvoirs.afficherResultatAction(nouveau.getNom()+" a été ajouté au terrain !");
            System.out.println(p.afficherPlateau(soi, adv));
        }
        else {
            AffichagePouvoirs.afficherResultatAction("Oups! la pioche est vide!");
        }
    }
}
