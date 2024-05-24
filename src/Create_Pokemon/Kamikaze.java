package Create_Pokemon;

import Create_Pokemon.Pokemon;
import Create_Pokemon.Power;
import Players.Joueur;

public class Kamikaze extends Power {

    private Pokemon m_possesseur;

    public Kamikaze(Pokemon possesseur){
        m_nom = "kamikaze";
        m_estUtilisable = true;
        m_possesseur = possesseur;
    }

    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {
        String nomCible = adv.choisirPokemon(adv.getTerrain(), "entraîner dans la mort");
        int j = 0;
        while(!adv.getTerrain().get(j).getNom().equals(nomCible)){
            j++;
        }
        Pokemon cible = (adv.getTerrain().get(j));
        soi.perdPokemon(m_possesseur);
        adv.perdPokemon(cible);

        m_estUtilisable = false;
    }
}
