package Affichage;

import Create_Pokemon.Pokemon;
import Players.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class AffichageJoueur {
    /**
     * Fait choisir à l'utilisateur un pokemon parmis une liste
     * @param liste : la liste des pokemons parmis lesquels il doit choisir
     * @return le nom du pokemon selectionne
     */
    public static String choisirPokemon(ArrayList<Pokemon> liste, String complementPhrase){
        Scanner scanner = new Scanner(System.in);
        boolean choixValide;
        System.out.print("Quel pokemon voulez-vous "+complementPhrase+" ? ("+listeChoixPoke(liste)+"): ");
        String choix = scanner.nextLine();
        choixValide = Joueur.pokemonExiste(choix,liste);
        while (!choixValide){
            System.out.println("\t--> Ce nom n'est pas valide, veuillez entrer un nom valide");
            System.out.print("Quel pokemon voulez-vous "+complementPhrase+" ? ("+listeChoixPoke(liste)+"): ");
            choix = scanner.nextLine();
            choixValide = Joueur.pokemonExiste(choix,liste);
        }
        return choix;
    }


    /**
     * fabrique la liste des noms des pokemons parmi lesquels l'utilisateur doit choisir
     * @param liste : liste des pokemons
     * @return la string contenant tous les noms
     */
    private static String listeChoixPoke(ArrayList<Pokemon> liste){
        String s = "";
        for (Pokemon p:liste
        ) {
            s = s.concat(p.getNom()+"/");
        }
        s = s.substring(0,s.length()-1);
        return s;
    }
}
