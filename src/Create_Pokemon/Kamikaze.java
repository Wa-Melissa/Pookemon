package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public class Kamikaze extends Power {

    private final Pokemon m_possesseur;

    public Kamikaze(Pokemon possesseur){
        m_nom = "kamikaze";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    @Override
    protected void declencherPouvoir(Joueur soi, Joueur adv) {
        String nomCible = adv.choisirPokemon(adv.getTerrain(), "entraîner dans la mort");
        int j = 0;
        while(!adv.getTerrain().get(j).getNom().equals(nomCible)){
            j++;
        }
        Pokemon cible = (adv.getTerrain().get(j));
        soi.perdPokemon(m_possesseur);
        adv.perdPokemon(cible);

        m_estUtilisable = false;

        AffichagePouvoirs.afficherResultatAction(m_possesseur.getNom()+" a réussi son attaque suicide contre "+cible.getNom()+". Ils ont tous les deux été éliminés !");
    }
}
