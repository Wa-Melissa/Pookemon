import Create_Pokemon.Pokemon;
import Gestion_Jeu.Joueur;
import Gestion_Jeu.Plateau;

public class Main
{
    public static void main(String[] args)
    {
        Joueur joueur1 = new Joueur("Max", 1);
        Joueur joueur2 = new Joueur("Ordinateur", 2);

        Pokemon pokemon = new Pokemon();
        System.out.println("Lancement du jeu ...");
        System.out.println(pokemon.toString());

        Pokemon deux = new Pokemon();
        System.out.println(deux.toString());

        Plateau plateau = new Plateau();
        System.out.println(plateau.afficherPlateau(joueur1, joueur2));

    }
}
