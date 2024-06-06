package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Kamikaze extends Power {

    private final Pokemon m_possesseur;

    protected Kamikaze(Pokemon possesseur){
        m_nom = "Kamikaze";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        if (!adv.getTerrain().isEmpty()){
            Pokemon cible = soi.trouverPokemon(adv.getTerrain(), "entraîner dans la mort");
            soi.perdPokemon(m_possesseur);
            adv.perdPokemon(cible);

            m_estUtilisable = false;

            AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a réussi son attaque suicide contre "+cible.getNom()+", ils ont tous les deux été éliminés !");
        }
        else {
            AffichagePouvoirs.afficherResultatAction(("Oups! Il n'y a aucun pokemon sur lequel utiliser ce pouvoir !"));
        }
    }

    @Override
    public String toString(){
        return super.toString() + " C'est le pokémon "+m_possesseur.getNom()+" qui possède ce pouvoir.";
    }
}
