package Affichage;
import Create_Pokemon.Powers.Power;
import java.util.Scanner;

public class AffichagePouvoirs {

    public static void demandeEffet(Power p){
        String nomPouvoir = p.getNom();
        System.out.print("Ce pokemon possède le pouvoir "+ nomPouvoir+" ! Voir son effet ? o/n");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        if (choix.equals("o")){
            String description;
            switch (nomPouvoir){
                case "Berserk" : description = "Ce pouvoir double l'attaque du pokemon choisit (unique)";break;
                case "Soin simple" : description="Ce pouvoir rends 30 pv au pokemon choisit (a chaque tour)" ;break;
                case "Soin de zone" : description="Ce pouvoir rends 10 pv à tous les pokemons de son terrain (a chaque tour)";break;
                case "Kamikaze" : description = "Ce Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés(unique)";break;
                case "Affinité Ether" : description = "Ce pouvoir donne au pokemon choisit un avantage contre tous les éléments (unique)";break;
                case "Affinité Plomb" : description = "Ce pouvoir donne a un pokemon adverse un désavantage contre tous les éléments (unique)";break;
                case "Usurpation" : description="Ce pouvoir mermet de voler le pouvoir de n'importe quel autre pokemon (unique)";break;
                default: description = "Ce pouvoir permet de placer exceptionellement un quatrième pokemon sur le terrain (unique)";
            }
            System.out.println(description);
        }
    }

    public static boolean autorisationUtilisation(){
        System.out.print("Voulez-vous utiliser ce pouvoir ? o/n");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        if (choix.equals("o")){
            return true;
        }
        return false;
    }

   /* public static String getNomPokeTerrain(){
        System.out.println("Sur quel pokemon voulez-vous utiliser le pouvoir ?");
    }*/
}
