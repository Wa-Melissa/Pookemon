package Gestion_Jeu;

import java.util.Scanner;

public class Gestion_Tour {

    public static String recuperePseudo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nVeuillez entrer un pseudo : ");
        String pseudo = scanner.nextLine();
        scanner.close();
        return pseudo;
    }
    public static void miseEnPlace(Joueur joueur1, Joueur joueur2){
        joueur1.piocher();
        if (joueur1.getClass()!=Ordinateur.class){
            joueur1.afficherJoueur() ;
        }
        joueur1.placerPokemon();

        joueur2.piocher();
        if (joueur2.getClass()!=Ordinateur.class){
            joueur2.afficherJoueur() ;
        }
        joueur2.placerPokemon();
    }

    public static void tourSuivant(Joueur joueur1, Joueur joueur2, Plateau plateau){
        joueur1.piocher();
        if (joueur1.getClass()!=Ordinateur.class){
            joueur1.afficherJoueur() ;
        }
        joueur1.placerPokemon();
        plateau.afficherPlateau(joueur1,joueur2);
        joueur1.attaquePokemon(joueur2);

        plateau.afficherPlateau(joueur1,joueur2);

        joueur2.piocher();
        if (joueur2.getClass()!=Ordinateur.class){
            joueur2.afficherJoueur() ;
        }
        joueur2.placerPokemon();
        joueur2.attaquePokemon(joueur1);

        plateau.afficherPlateau(joueur1,joueur2);
    }

    public static void affichageFin(Joueur joueur){
        if (joueur.aPerdu()){
            System.out.println("\nVous avez perdu !");
        } else {            System.out.println("\nVous avez gagné ! :)");
        }
    }
}
