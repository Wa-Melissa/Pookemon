package Affichage;

import java.util.Scanner;

public class AffichagePouvoirs {

    /**
     * affiche les effets d'un pouvoir si l'utilisateur souhaite les voir
     * @param nomPouvoir, le nom du pouvoir dont on veut afficher l'effet
     */
    public static void demandeEffet(String nomPouvoir){
        System.out.print("Ce pokemon possède le pouvoir "+ nomPouvoir+" ! Voir son effet ? o/n ");
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        if (choix.equals("o")){
            String description;
            switch (nomPouvoir){
                case "Berserk" : description = "Ce pouvoir double l'attaque du pokemon choisit (unique)";break;
                case "Soin simple" : description="Ce pouvoir rends 30 pv au pokemon choisit (a chaque tour)" ;break;
                case "Soin de zone" : description="Ce pouvoir rends 10 pv à tous les pokemons de son terrain (a chaque tour)";break;
                case "Kamikaze" : description = "Ce Pokémon choisit un Pokémon du camp adverse. Les deux Pokémons sont alors éliminés(unique)";break;
                case "Regeneration" : description = "Ce pouvoir permet de réutiliser un pouvoir déjà utilisé (unique)";break;
                case "Peur" : description = "Ce pouvoir diminue de 10 l'attaque d'un pokemon adverse (unique)";break;
                case "Usurpation" : description="Ce pouvoir mermet de voler le pouvoir de n'importe quel autre pokemon (unique)";break;
                default: description = "Ce pouvoir permet de placer exceptionellement un quatrième pokemon sur le terrain (unique)";
            }
            System.out.println(description);
        }
    }

    /**
     * affiche la demande de validation de l'utilisation du pouvoir
     */
    public static void autorisationUtilisation(){
        System.out.print("Voulez-vous utiliser ce pouvoir ? o/n ");
    }

    /**
     * affiche le resultat de l'action d'un pouvoir déclenché
     * @param texte, string decrivant l'effet produit
     */
    public static void afficherResultatAction(String texte){
        System.out.println("* "+texte+" *");
    }

}
