package Gestion_Jeu;

import Affichage.Affichage_Plateau;
import Players.Joueur;
import Players.Ordinateur;

import java.util.Random;
import java.util.Scanner;

public class Gestion_Tour {

    private final int m_pnjCommence; //1 pour true, 0 pour false
    private final Joueur m_joueur1;
    private final Joueur m_joueur2;
    private final Affichage_Plateau m_plateau;

    /**
     * Crée un gestionnaire de tours
     */
    public Gestion_Tour(){
        //Initialisation des joueurs
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez entrer votre pseudo : ");
        String name = scanner.nextLine();
        System.out.println("Bonjour " + name + " !\nBienvenue dans Pookémon ! Prépare toi au combat.");
        Random rdt = new Random();
        m_pnjCommence = rdt.nextInt(2); // 0 pour non, 1 pour oui
        if (m_pnjCommence==0){
            m_joueur1 = new Joueur(name, true);
            m_joueur2 = new Ordinateur("Ordinateur", false);
            System.out.println("\nC'est vous qui commencez !\n");
        }else {
            m_joueur1 = new Ordinateur("Ordinateur", true);
            m_joueur2 = new Joueur(name, false);
            System.out.println("\nC'est votre adversaire qui commence!\n");
        }

        m_plateau  = new Affichage_Plateau();
    }

    /**
     * Fait la mise en place de la partie
     */
    public void miseEnPlace(){
        m_joueur1.piocher();

        if (m_pnjCommence == 0){
            System.out.println("Placez vos pokemons !");
            System.out.println(m_plateau.afficherMain(m_joueur1));
        }
        m_joueur1.placerPokemon();

        m_joueur2.piocher();
        if (m_pnjCommence != 0){
            System.out.println("Placez vos pokemons !");
            System.out.println(m_plateau.afficherMain(m_joueur2));
        }
        m_joueur2.placerPokemon();

        Affichage_Plateau.afficheDepart(m_joueur1);

    }

    /**
     * appelle toutes les actions d'dun tour de jeu
     */
    public void tourSuivant(){

        m_joueur1.piocher();
        m_joueur1.placerPokemon();


        if (m_pnjCommence == 0){
            System.out.println(m_plateau.afficherPlateau(m_joueur1, m_joueur2));
            System.out.println(m_plateau.afficherMain(m_joueur1));
        }
        m_joueur1.utiliserPouvoir(m_joueur2);
        m_joueur1.attaquePokemon(m_joueur2);
        if (m_pnjCommence != 0){
            System.out.println(m_plateau.afficherPlateau(m_joueur1, m_joueur2));
            System.out.println(m_plateau.AfficheResume());
        }


        if (m_pnjCommence != 0){
            System.out.println(m_plateau.afficherMain(m_joueur2));

        }

        m_joueur2.piocher();

        m_joueur2.placerPokemon();
        m_joueur2.utiliserPouvoir(m_joueur1);
        m_joueur2.attaquePokemon(m_joueur1);
        System.out.println(m_plateau.afficherPlateau(m_joueur1, m_joueur2));
        if (m_pnjCommence == 0){
            System.out.println(m_plateau.AfficheResume());
        }
        m_plateau.ajouterTour();

    }


    /**
     * Affiche à la fin de la partie si l'utilisateur a gagné ou perdu
     */
    public void affichageFin(){
        if (m_pnjCommence==0){
            if (m_joueur1.aPerdu()){
                System.out.println("\nVous avez perdu !");
            } else {
                System.out.println("\nVous avez gagné ! :)");
            }
        }
        else {
            if (m_joueur2.aPerdu()){
                System.out.println("\nVous avez perdu !");
            } else {
                System.out.println("\nVous avez gagné ! :)");
            }
        }
    }

    /**
     * @return true si le joueur 1 a perdu, false sinon
     */
    public boolean Joueur1aPerdu(){
        return m_joueur1.aPerdu();
    }

    /**
     * @return true si le joueur 2 a perdu, false sinon
     */
    public boolean Joueur2aPerdu(){
        return m_joueur2.aPerdu();
    }

}
