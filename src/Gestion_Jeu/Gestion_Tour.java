package Gestion_Jeu;

import Affichage.Plateau;

public class Gestion_Tour {

    /**
     * Fait la mise en place de la partie
     * @param joueur1 le joueur qui commence
     * @param joueur2 l'autre joueur
     * @param plateau le plateau de jeu
     */
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

    /**
     * appelle toutes les actions d'dun tour de jeu
     * @param joueur1 le joueur qui commence
     * @param joueur2 l'autre joueur
     * @param plateau le plateau de jeu
     */
    public static void tourSuivant(Joueur joueur1, Joueur joueur2, Plateau plateau){
        joueur1.piocher();
        if (!(joueur1 instanceof Ordinateur)){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherPlateau(joueur1,joueur2));
            plateau.ajouterTour();
        }
        joueur1.placerPokemon();

        joueur1.attaquePokemon(joueur2);

        System.out.println(plateau.afficherPlateau(joueur1, joueur2));

        joueur2.piocher();
        if (!(joueur1 instanceof  Ordinateur)){
            System.out.println("Placez vos pokemons !");
            System.out.println(plateau.afficherMain(joueur2));
            plateau.ajouterTour();
        }
        joueur2.placerPokemon();
        joueur2.attaquePokemon(joueur1);

        System.out.println(plateau.afficherPlateau(joueur1, joueur2));
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
