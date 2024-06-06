import Gestion_Jeu.Gestion_Tour;
import Affichage.Affichage_Plateau;

public class Main
{
    public static void main(String[] args)
    {
        //Initialisation des joueurs
        Gestion_Tour partie1 = new Gestion_Tour();
        partie1.miseEnPlace();

        Affichage_Plateau.affichageDebut();

        //tours de jeu
        while (!partie1.Joueur1aPerdu() && !partie1.Joueur2aPerdu()){
            partie1.tourSuivant();
        }

        //Affichage fin
        partie1.affichageFin();
    }
}
