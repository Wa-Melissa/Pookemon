package Create_Pokemon;

import Players.Joueur;

public abstract class Power {

    protected String m_nom;//Nom du pouvoir

    protected Boolean m_estUtilisable = true; //Faux si usage unique et déjà utilisé, vrai sinon

    public String getNom(){
        return m_nom;
    }

    /**
     * declenche le pouvoir si les conditions sont réunies
     * @param soi, le joueur qui lance le pouvoir
     * @param adv, le joueur adverse
     */
    public void utiliserPouvoir(Joueur soi, Joueur adv){
        if (soi.autoriserPouvoir()){
            declencherPouvoir(soi, adv);
        }
    }

    /**
     * met fin a l'action du pouvoir
     */
    public void finEffetPouvoir(){}

    /**
     * produit tous les effets du pouvoir
     * @param soi, le Joueur qui déclenche un pouvoir
     * @param adv, son adversaire
     */
    protected abstract void declencherPouvoir(Joueur soi, Joueur adv);

    /**
     * renvoie l'utilisabilité du pouvoir
     * @return true si le pouvoir est utilisable, false sinon
     */
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
