package Gestion_Jeu;

import java.util.Scanner;

public class Gestion_Tour {

    public static void miseEnPlace(Joueur joueur1, Joueur joueur2, Plateau plateau){
        joueur1.piocher();
        if (joueur1.getClass()!=Ordinateur.class){
            System.out.println(plateau.afficherMain(joueur1));
        }
        joueur1.placerPokemon();

        joueur2.piocher();
        if (joueur2.getClass()!=Ordinateur.class){
            System.out.println(plateau.afficherMain(joueur2));
        }
        joueur2.placerPokemon();
       // System.out.println(plateau.afficherPlateau(joueur1, joueur2));

    }

    public static void tourSuivant(Joueur joueur1, Joueur joueur2, Plateau plateau){
        joueur1.piocher();
        if (!(joueur1 instanceof Ordinateur)){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherPlateau(joueur1,joueur2));
            plateau.m_tour++;
        }
        joueur1.placerPokemon();

        joueur1.attaquePokemon(joueur2);

        System.out.println(plateau.afficherPlateau(joueur1, joueur2));

        joueur2.piocher();
        if (!(joueur1 instanceof  Ordinateur)){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherMain(joueur2));
            plateau.m_tour++;
        }
        joueur2.placerPokemon();
        joueur2.attaquePokemon(joueur1);

        System.out.println(plateau.afficherPlateau(joueur1, joueur2));
    }

    public static void affichageFin(Joueur joueur){
        if (joueur.aPerdu()){
            System.out.println("\nVous avez perdu !");
        } else {            System.out.println("\nVous avez gagné ! :)");
        }
    }
}
