package Gestion_Jeu;

import Affichage.Affichage_Plateau;
import Players.Joueur;
import Players.Ordinateur;

public class Gestion_Tour {

    /**
     * Fait la mise en place de la partie
     * @param joueur1 le joueur qui commence
     * @param joueur2 l'autre joueur
     * @param plateau le plateau de jeu
     */
    public static void miseEnPlace(Joueur joueur1, Joueur joueur2, Affichage_Plateau plateau){
        joueur1.piocher();

        if (joueur1.getClass()!= Ordinateur.class){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherMain(joueur1));
        }
        joueur1.placerPokemon();

        joueur2.piocher();
        if (joueur2.getClass()!=Ordinateur.class){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherMain(joueur2));
        }
        joueur2.placerPokemon();

    }

    /**
     * appelle toutes les actions d'dun tour de jeu
     * @param joueur1 le joueur qui commence
     * @param joueur2 l'autre joueur
     * @param plateau le plateau de jeu
     */
    public static void tourSuivant(Joueur joueur1, Joueur joueur2, Affichage_Plateau plateau){

        joueur1.piocher();
        joueur1.placerPokemon();


        if (!(joueur1 instanceof  Ordinateur)){
            System.out.println(plateau.afficherPlateau(joueur1, joueur2));
            System.out.println(plateau.afficherMain(joueur1));
        }
        joueur1.utiliserPouvoir(joueur2);
        joueur1.attaquePokemon(joueur2);
        if ((joueur1 instanceof  Ordinateur)){
            System.out.println(plateau.afficherPlateau(joueur1, joueur2));
            System.out.println(plateau.AfficheResume());
        }


        if (!(joueur2 instanceof  Ordinateur)){
            System.out.println(plateau.afficherMain(joueur2));

        }

        joueur2.piocher();

        joueur2.placerPokemon();
        joueur2.utiliserPouvoir(joueur1);
        joueur2.attaquePokemon(joueur1);
        System.out.println(plateau.afficherPlateau(joueur1, joueur2));
        if ((joueur2 instanceof  Ordinateur)){
            System.out.println(plateau.AfficheResume());
        }
        plateau.ajouterTour();

    }

    /**
     * Affiche à la fin de la partie si l'utilisateur a gagné ou perdu
     * @param joueur le joueur joué par l'utilisateur
     */
    public static void affichageFin(Joueur joueur){
        if (joueur.aPerdu()){
            System.out.println("\nVous avez perdu !");
        } else {            System.out.println("\nVous avez gagné ! :)");
        }
    }


}
