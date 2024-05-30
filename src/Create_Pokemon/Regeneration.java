package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Regeneration extends Power{

    public final Pokemon m_possesseur;

    protected Regeneration(Pokemon possesseur)
    {
        m_nom = "Regeneration";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv)
    {
        if (!soi.getTerrain().isEmpty())
        {
            Pokemon cible = soi.trouverPokemon(soi.getTerrain(), "Regenere le pouvoir");
            cible.getPower().m_estUtilisable = true;

            m_estUtilisable = false;

            AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a régénéré le pouvoir de "+cible.getNom()+" !");
        } else
        {
            AffichagePouvoirs.afficherResultatAction("Mince, ce Pokémon n'a pas de pouvoir...");
        }
    }
}
