package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Kamikaze extends Power {

    private final Pokemon m_possesseur;

    protected Kamikaze(Pokemon possesseur){
        m_nom = "kamikaze";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        Pokemon cible = soi.trouverPokemon(adv.getTerrain(), "entraîner dans la mort");
        soi.perdPokemon(m_possesseur);
        adv.perdPokemon(cible);

        m_estUtilisable = false;

        AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a réussi son attaque suicide contre "+cible.getNom()+". Ils ont tous les deux été éliminés !");
    }

    @Override
    public String toString(){
        return super.toString() + " C'est le pokémon "+m_possesseur.getNom()+" qui possède ce pouvoir.";
    }
}
