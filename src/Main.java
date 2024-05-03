import Gestion_Jeu.Joueur;
import Gestion_Jeu.Ordinateur;
import Gestion_Jeu.Plateau;

public class Main
{
    public static void main(String[] args)
    {
        Joueur joueur1 = new Ordinateur("Max", false);
        Joueur ordi = new Ordinateur("Ordinateur", true);

        System.out.println("Lancement du jeu ...");

        ordi.piocher();
        ordi.placerPokemon();

        joueur1.piocher();
        joueur1.placerPokemon();

        Plateau plateau = new Plateau();
        System.out.println(plateau.afficherPlateau(joueur1, ordi));

        joueur1.attaquePokemon(ordi);

        System.out.println(plateau.afficherPlateau(joueur1, ordi));


    }
}
