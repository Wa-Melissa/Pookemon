package Create_Pokemon;

import Affichage.AffichagePouvoirs;
import Players.Joueur;

import java.util.Scanner;

public abstract class Power {

    protected String m_nom;//Nom du pouvoir
    protected Boolean m_estUtilisable; //Faux si usage unique et déjà utilisé, vrai sinon

    public String getNom(){
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

    private boolean autorisationUtilisation(){
        AffichagePouvoirs.autorisationUtilisation();
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        return choix.equals("o");
    }

    protected abstract void declencherPouvoir(Joueur soi, Joueur adv);
}
