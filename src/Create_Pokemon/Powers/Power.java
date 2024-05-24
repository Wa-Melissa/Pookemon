package Create_Pokemon.Powers;

import Affichage.AffichagePouvoirs;
import Create_Pokemon.Pokemon;

public abstract class Power {

    String m_nom;//Nom du pouvoir
    Boolean m_estUtilisable; //Faux si usage unique et déjà utilisé, vrai sinon

    public String getNom(){
        return m_nom;
    }

    public void utiliserPouvoir(){
        if (m_estUtilisable){
            AffichagePouvoirs.demandeEffet(this);
            if (AffichagePouvoirs.autorisationUtilisation()){

            }
        }
    }

    abstract void declencherPouvoir();
/*
    Pokemon getPokemonTerrain(){
        String nomPokemon = AffichagePouvoirs.getNomPokeTerrain();
    }*/

}
