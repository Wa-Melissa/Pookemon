package Create_Pokemon.Powers;

import Create_Pokemon.Pokemon;
import Players.Joueur;

public class SoinZone extends Power{
    public SoinZone(){
        m_nom = "soin de zone";
        m_estUtilisable = true;
    }

    @Override
    void declencherPouvoir(Joueur soi, Joueur adv) {
        for (int i = 0 ; i < soi.getTerrain().size() ; i++){
            soi.getTerrain().get(i).estSoigne(10);
        }
    }
}
