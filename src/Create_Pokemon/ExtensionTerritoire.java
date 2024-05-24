package Create_Pokemon;

import Create_Pokemon.Power;
import Players.Joueur;

public class ExtensionTerritoire extends Power {

    public ExtensionTerritoire(){
        m_nom = "extension du territoire";
        m_estUtilisable = true;
    }

    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {

    }
}
