package Create_Pokemon.Powers;

import Create_Pokemon.Pokemon;
import Players.Joueur;

public class Berserk extends Power{
    Pokemon m_receveur;

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
        m_receveur.setAttaque(m_receveur.getAttaque()*2);
    }
}
