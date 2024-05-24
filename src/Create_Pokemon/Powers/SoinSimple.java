package Create_Pokemon.Powers;

import Create_Pokemon.Pokemon;
import Players.Joueur;

public class SoinSimple extends Power{

    public SoinSimple(){
        m_nom = "soin simple";
        m_estUtilisable = true;
    }


    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {
        String nomReceveur = soi.choisirPokemon(soi.getTerrain(), "soigner");
        int j = 0;
        while(!soi.getTerrain().get(j).getNom().equals(nomReceveur)){
            j++;
        }
        Pokemon receveur = (soi.getTerrain().get(j));
        receveur.estSoigne(30);
    }
}
