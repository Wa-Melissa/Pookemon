package Create_Pokemon;

import Players.Joueur;

public class Empoisonnement extends Power {

    protected Empoisonnement()
    {
        m_nom = "Regeneration";
        m_estUtilisable = true;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {

    }

}
