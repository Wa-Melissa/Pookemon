import Gestion_Jeu.Joueur;
import Gestion_Jeu.Plateau;

public class Main
{
    public static void main(String[] args)
    {
        Joueur joueur1 = new Joueur("Max", true);
        Joueur joueur2 = new Joueur("Ordinateur", false);

        System.out.println("Lancement du jeu ...");

        joueur2.piocher();
        joueur2.placerPokemon();
        joueur1.piocher();
        joueur1.placerPokemon();

        Plateau plateau = new Plateau();
        System.out.println(plateau.afficherPlateau(joueur1, joueur2));


    }
}
