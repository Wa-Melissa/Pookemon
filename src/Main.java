import Gestion_Jeu.Gestion_Tour;
import Players.Joueur;
import Players.Ordinateur;
import Affichage.Affichage_Plateau;

import java.util.Random;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Initialisation des joueurs
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre pseudo : ");
        String name = scanner.nextLine();
        System.out.println("Bonjour " + name + " !\nBienvenue dans Pookémon ! Prépare toi au combat.");
        Joueur joueur1;
        Joueur joueur2;
        Random rdt = new Random();
        int pnjCommence = rdt.nextInt(2); // 0 pour non, 1 pour oui
        if (pnjCommence==0){
             joueur1 = new Joueur(name, true);
             joueur2 = new Ordinateur("Ordinateur", false);
             System.out.println("\nC'est vous qui commencez !\n");
        }else {
             joueur1 = new Ordinateur("Ordinateur", true);
             joueur2 = new Joueur(name, false);
             System.out.println("\nC'est votre adversaire qui commence!\n");
        }
        Affichage_Plateau plateau  = new Affichage_Plateau();


        Gestion_Tour.miseEnPlace(joueur1,joueur2, plateau);

        String separation = "===========================================================================================================================\n";
        String goAffichage = "C'est parti !!";
        String espace = "";
        for(int i = 0; i < (separation.length() - goAffichage.length())/2; i++)
        {
            espace += " ";
        }
        System.out.println("\u001B[32m" + separation +

                separation + espace + goAffichage + "\n"
                + separation + separation + "\u001B[0m");


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
