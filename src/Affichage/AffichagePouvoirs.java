package Affichage;

import java.util.Scanner;

public class AffichagePouvoirs {

    public static void demandeEffet(String nomPouvoir){
        System.out.print("Un pokemon possède le pouvoir "+ nomPouvoir+" ! Voir son effet ? o/n ");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        if (choix.equals("o")){
            String description;
            switch (nomPouvoir){
                case "berserk" : description = "Ce pouvoir double l'attaque du pokemon choisit (unique)";break;
                case "soin simple" : description="Ce pouvoir rends 30 pv au pokemon choisit (a chaque tour)" ;break;
                case "soin de zone" : description="Ce pouvoir rends 10 pv à tous les pokemons de son terrain (a chaque tour)";break;
                case "kamikaze" : description = "Ce Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés(unique)";break;
                case "affinité Ether" : description = "Ce pouvoir donne au pokemon choisit un avantage contre tous les éléments (unique)";break;
                case "affinité Plomb" : description = "Ce pouvoir donne a un pokemon adverse un désavantage contre tous les éléments (unique)";break;
                case "usurpation" : description="Ce pouvoir mermet de voler le pouvoir de n'importe quel autre pokemon (unique)";break;
                default: description = "Ce pouvoir permet de placer exceptionellement un quatrième pokemon sur le terrain (unique)";
            }
            System.out.println(description);
        }
    }

    public static void autorisationUtilisation(){
        System.out.print("Voulez-vous utiliser ce pouvoir ? o/n ");
    }

    public static void afficherResultatAction(String texte){
        System.out.println("* "+texte+" *");
    }

}
