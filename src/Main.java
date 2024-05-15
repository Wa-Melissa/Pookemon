import Gestion_Jeu.Gestion_Tour;
import Gestion_Jeu.Joueur;
import Gestion_Jeu.Ordinateur;
import Gestion_Jeu.Plateau;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre pseudo : ");
        String name = scanner.nextLine();
        System.out.println("Bonjour " + name + " !\nBienvenue dans Pookémon ! Prépare toi au combat.");

        //Initialisation des joueurs
        Joueur joueur1;
        Joueur joueur2;
        //String pseudo = Gestion_Tour.recuperePseudo(); --> problemes avec le scanner
        Random rdt = new Random();
        int pnjCommence = rdt.nextInt(2); // 0 pour non, 1 pour oui
        if (pnjCommence==0){
             joueur1 = new Joueur(name, true);
             joueur2 = new Ordinateur("Ordinateur", false);
             System.out.println("\nC'est vous qui commencez !");
        }else {
             joueur1 = new Ordinateur("Ordinateur", true);
             joueur2 = new Joueur(name, false);
             System.out.println("C'est votre adversaire qui commence!");
        }

        Plateau plateau  = new Plateau();



        Gestion_Tour.miseEnPlace(joueur1,joueur2);

        System.out.println(plateau.afficherPlateau(joueur1, joueur2));

        //tours de jeu
        while (!joueur1.aPerdu() && !joueur2.aPerdu()){
            Gestion_Tour.tourSuivant(joueur1,joueur2,plateau);
        }

        //Affichage fin
        if (pnjCommence==0){
            Gestion_Tour.affichageFin(joueur1);
        }
        else {
            Gestion_Tour.affichageFin(joueur2);
        }
    }
}
