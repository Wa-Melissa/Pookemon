package Create_Pokemon;

import Create_Pokemon.Pokemon;
import Create_Pokemon.Power;
import Players.Joueur;

public class Berserk extends Power {
    private Pokemon m_receveur;

    public Berserk(){
        m_nom = "berserk";
        m_estUtilisable = true;
    }

    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {
        String nomReceveur = soi.choisirPokemon(soi.getTerrain(), "rendre Berserk");
        int j = 0;
        while(!soi.getTerrain().get(j).getNom().equals(nomReceveur)){
            j++;
        }
        m_receveur = (soi.getTerrain().get(j));
        m_receveur.m_attaque *= 2;
        m_estUtilisable = false;
    }
}
