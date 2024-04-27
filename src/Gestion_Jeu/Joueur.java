package Gestion_Jeu;

import Create_Pokemon.Pokemon;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    protected boolean m_commence ; // 1 si le joueur commence, 2 sinon
    protected String m_pseudo;
    protected ArrayList<Pokemon> m_pioche;
    protected ArrayList<Pokemon> m_main;
    protected ArrayList<Pokemon> m_defausse;
    protected ArrayList<Pokemon> m_terrain;

    /**
     * Crée un joueur
     * @param pseudo : le pseudo du joueur
     * @param commence : true s'il commence, false sinon
     */
    public Joueur(String pseudo, boolean commence){
        m_pseudo = pseudo;
        m_commence = commence;
        m_pioche = new ArrayList<>(21);
        m_main = new ArrayList<>(5);
        m_defausse = new ArrayList<>();
        m_terrain = new ArrayList<>(3);
        for (int i = 0 ; i<21 ; i++){
            m_pioche.add(new Pokemon());
        }
        if (!m_commence){ m_pioche.add(new Pokemon());}
    }

    /**
     * complète la main du joueur avec la pioche
     */
    public void piocher(){
        while (m_main.size()<5 && !m_pioche.isEmpty()){
            Random rdt = new Random();
            m_main.add(m_pioche.remove(rdt.nextInt(m_pioche.size())));
        }
    }

    /**
     * déplace les pokemons du choix du joueur de sa main vers son terrain
     */
    public void placerPokemon(){
        while(m_terrain.size()<3){
            String choix = choisirPokemon(m_main);
            bougerPokemon(choix,m_main,m_terrain);
        }
    }

    /**
     * déplace un pokemon d'une liste à une autre à partir de son nom
     * @param nom : nom du pokemon a deplacer, doit être dans dans départ
     * @param depart : la ou est actuellement le pokemon a deplacer
     * @param arrivee : la ou il doit être déplacé
     */
    protected void bougerPokemon(String nom,ArrayList<Pokemon> depart, ArrayList<Pokemon> arrivee ){
        for (int i = 0 ; i< depart.size() ; i++){
            Pokemon p = depart.get(i);
            if (p.getNom().equals(nom)){
                arrivee.add(p);
                depart.remove(i);
                break;
            }
        }
    }

    /**
     * Fait choisir à l'utilisateur un pokemon parmis une liste
     * @param liste : la liste des pokemons parmis lesquels il doit choisir
     * @return le nom du pokemon sélectionné
     */
    protected String choisirPokemon(ArrayList<Pokemon> liste){
        Scanner scanner = new Scanner(System.in);
        boolean choixValide = false;
        String choix = "";
        while (!choixValide){
            System.out.print("Quel pokemon voulez-vous placer ? ("+listeChoixPoke(liste)+"): ");
            choix = scanner.nextLine();
            choixValide = pokemonExiste(choix,liste);
        }
        return choix;
    }

    /**
     * Vérifie qu'un pokemon existe dans une liste à partir de son nom
     * @param nom : le nom du pokemon
     * @param liste : la liste dans laquelle on veut cherchee
     * @return true s'il est dans la liste, false sinon
     */
    protected boolean pokemonExiste(String nom,ArrayList<Pokemon> liste){
        for (Pokemon p:liste
        ) {
            if (nom.equals(p.getNom())){
                return true;
            }
        }
        return false;
    }

    /**
     * fabrique la liste des noms des pokemons parmi lesquels l'utilisateur doit choisir
     * @param liste : liste des pokemons
     * @return la string contenant tous les noms
     */
    protected String listeChoixPoke(ArrayList<Pokemon> liste){
        String s = "";
        for (Pokemon p:liste
             ) {
            s = s.concat(p.getNom()+"/");
        }
        s = s.substring(0,s.length()-1);
        return s;
    }

    //methode pour tests
    public void afficherJoueur(){
        System.out.println("pseudo:"+m_pseudo);
        System.out.println("nombre de cartes dans la pioche:"+m_pioche.size());
        System.out.println("pioche:"+m_pioche.toString());
        System.out.println("\n\nnb en main:"+m_main.size());
        System.out.println("main:"+m_main.toString());
        System.out.println("\n\nnb terrain:"+m_terrain.size());
        System.out.println("terrain:"+m_terrain.toString());
    }


}
