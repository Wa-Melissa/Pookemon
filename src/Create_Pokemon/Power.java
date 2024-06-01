package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

public abstract class Power {

    protected String m_nom;//Nom du pouvoir

    protected Boolean m_estUtilisable = true; //Faux si usage unique et déjà utilisé, vrai sinon

    public String getNom(){
        return m_nom;
    }

    public void utiliserPouvoir(Joueur soi, Joueur adv){
        if (autorisationUtilisation(soi)){
            declencherPouvoir(soi, adv);
        }
    }

    public void finEffetPouvoir(){}

    private boolean autorisationUtilisation(Joueur soi){
        return soi.autoriserPouvoir();
    }

    protected abstract void declencherPouvoir(Joueur soi, Joueur adv);

    public boolean isUtilisable(){
        return m_estUtilisable;
    }

    @Override
    public String toString(){
        if (m_estUtilisable){
            return "Le pouvoir "+getNom()+" est utilisable.";
        }
        else {
            return "Le pouvoir "+getNom()+" a déjà été utilisé et n'est plus utilisable.";
        }
    }
}
