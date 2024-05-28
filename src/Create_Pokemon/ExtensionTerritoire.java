package Create_Pokemon;

import Players.Joueur;

public class ExtensionTerritoire extends Power {

    protected ExtensionTerritoire(){
        m_nom = "Extension du territoire";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {

    }
}
