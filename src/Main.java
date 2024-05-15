import java.io.IOException;
import java.util.Scanner;
import Gestion_Jeu.Joueur;
import Gestion_Jeu.Ordinateur;
import Gestion_Jeu.Plateau;

public class Main
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre pseudo : ");
        String name = scanner.nextLine();
        System.out.println("Bonjour " + name + " !\nBienvenue dans Pookémon ! Prépare toi au combat.");

        Joueur joueur1 = new Ordinateur(name, false);
        Joueur ordi = new Ordinateur("Ordinateur", true);

        System.out.println("Lancement de la partie ...");

        ordi.piocher();
        ordi.placerPokemon();

        joueur1.piocher();
        joueur1.placerPokemon();

        Plateau plateau = new Plateau();
        System.out.println(plateau.afficherPlateau(joueur1, ordi));

        ordi.attaquePokemon(joueur1);



        System.out.println(plateau.afficherPlateau(joueur1, ordi));


    }
}
