package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Create_Pokemon.Pokemon;
import Players.Joueur;

import java.util.Scanner;

public abstract class Power {

    String m_nom = "";//Nom du pouvoir
    Boolean m_estUtilisable; //Faux si usage unique et déjà utilisé, vrai sinon

    public String getNom()
    {
        if(m_nom.isEmpty())
        {
            return "//////////////";
        }
        return m_nom;
    }

    public void utiliserPouvoir(Joueur soi, Joueur adv){
        if (m_estUtilisable){
            AffichagePouvoirs.demandeEffet(this);
            if (autorisationUtilisation()){
                declencherPouvoir(soi, adv);
            }
        }
    }

    public boolean autorisationUtilisation(){
        AffichagePouvoirs.autorisationUtilisation();
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        if (choix.equals("o")){
            return true;
        }
        return false;
    }

    abstract void declencherPouvoir(Joueur soi, Joueur adv);

}
