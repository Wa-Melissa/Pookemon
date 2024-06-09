package Players;

import Affichage.AffichageJoueur;
import Affichage.AffichagePouvoirs;
import Create_Pokemon.ActionsJoueur;
import Create_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class Joueur implements ActionsJoueur {
    protected boolean m_commence ; // 1 si le joueur commence, 2 sinon
    protected String m_pseudo;
    protected ArrayList<Pokemon> m_pioche;
    protected ArrayList<Pokemon> m_main;
    protected ArrayList<Pokemon> m_defausse;
    protected ArrayList<Pokemon> m_terrain;

    /**
     * Cree un joueur
     * @param pseudo : le pseudo du joueur
     * @param commence : true s'il commence, false sinon, doit etre different de l'attribut de l'ordinateur
     */
    public Joueur(String pseudo, boolean commence){
        m_pseudo = pseudo;
        m_commence = commence;
        m_pioche = new ArrayList<>(21);
        m_main = new ArrayList<>(5);
        m_defausse = new ArrayList<>();
        m_terrain = new ArrayList<>(3);
        for (int i = 0 ; i<20 ; i++){
            m_pioche.add(new Pokemon());
        }
        if (!m_commence){ m_pioche.add(new Pokemon());}
    }

    /**
     * complete la main du joueur avec la pioche
     */
    public void piocher(){
        while (m_main.size()<5 && !m_pioche.isEmpty()){
           // Random rdt = new Random();
            m_main.add(m_pioche.remove(0));
        }
    }

    /**
     * deplace les pokemons du choix du joueur de sa main vers son terrain
     */
    public void placerPokemon(){
        while(m_terrain.size()<3){
            String choix = AffichageJoueur.choisirPokemon(m_main,"placer");
            bougerPokemon(choix,m_main,m_terrain);
        }
    }

    /**
     * attaque l'adversere une fois avec chaque pokemon du terrain, dans l'ordre du choix de l'utilisateur
     * @param adversaire : Joueur ou Ordinateur qu'on attaque
     */
    public void attaquePokemon(Joueur adversaire){
        ArrayList<Pokemon> attaquants = (ArrayList<Pokemon>) m_terrain.clone();
        for ( int i = 0 ; i< 4 && !attaquants.isEmpty(); i++){
            String pokemonChoisi = AffichageJoueur.choisirPokemon(attaquants,"jouer");
            int j = 0;
            while(!attaquants.get(j).getNom().equals(pokemonChoisi)){
                j++;
            }
            Pokemon monPokemon = (attaquants.remove(j));
            Pokemon pokemonAdverse = trouverPokemon(adversaire.m_terrain,"attaquer");
            monPokemon.attaque(pokemonAdverse, adversaire);
        }

        finirPouvoir();
    }

    /**
     * Trouve un pokemon choisi par le joueur
     * @param zoneRecherche, la liste de pokemons parmi laquelle le joueur doit choisir
     * @param complementPhrase, string completant la question pour le joueur
     * @return le pokemon choisi
     */
    public Pokemon trouverPokemon(ArrayList<Pokemon> zoneRecherche, String complementPhrase){
        String nomPokemonCherche = AffichageJoueur.choisirPokemon(zoneRecherche, complementPhrase);
        int j = 0;
        while(!zoneRecherche.get(j).getNom().equals(nomPokemonCherche)){
            j++;
        }
        return zoneRecherche.get(j);
    }

    /**
     * permet d'utiliser tous les pouvoirs du terrain du joueur
     * @param adv, l'adversaire du joueur
     */
    public void utiliserPouvoir( Joueur adv){
        ArrayList<Pokemon> terrain = (ArrayList<Pokemon>) m_terrain.clone();
        ArrayList<Pokemon> possesseursPouvoirs = new ArrayList<>() ;
        for (Pokemon p :terrain ) {
            if (p.possedePouvoir()){
                if (p.getPower().isUtilisable()) {
                    possesseursPouvoirs.add(p);
                }
            }
        }
        for ( int i = 0 ; i< 4 && !possesseursPouvoirs.isEmpty(); i++){
            String pokemonChoisi = AffichageJoueur.choisirPokemon(possesseursPouvoirs,"faire activer son pouvoir");
            int j = 0;
            while(!possesseursPouvoirs.get(j).getNom().equals(pokemonChoisi)){
                j++;
            }
            Pokemon monPokemon = (possesseursPouvoirs.remove(j));
            AffichagePouvoirs.demandeEffet(monPokemon.getPower().getNom());
            monPokemon.getPower().utiliserPouvoir(this, adv);
        }
    }

    /**
     * met fin a l'action des pouvoirs qui ont un temps d'effet limité
     */
    protected void finirPouvoir(){
        ArrayList<Pokemon> attaquants = (ArrayList<Pokemon>) m_terrain.clone();
        for (Pokemon p :attaquants ) {
            if (p.possedePouvoir()){
                if (!p.getPower().isUtilisable()) {
                    p.getPower().finEffetPouvoir();
                }
            }
        }
    }

    /**
     * recupere l'autorisation du joueur d'activer un pouvoir
     * @return true si le joueur est d'accord, false sinon
     */
    public boolean autoriserPouvoir(){
        AffichagePouvoirs.autorisationUtilisation();
        Scanner scanner = new Scanner(System.in);
        String choix = scanner.nextLine();
        return choix.equals("o");
    }


    /**
     * Retire un pokemon du terrain et le place dans la defausse
     * @param p : Pokemon, doit etre sur le terrain
     */
    public void perdPokemon(Pokemon p) {
        m_defausse.add(p);
        m_terrain.remove(p);
    }


    /**
     * deplace un pokemon d'une liste à une autre à partir de son nom
     * @param nom : nom du pokemon a deplacer, doit etre dans dans depart
     * @param depart : la ou est actuellement le pokemon a deplacer
     * @param arrivee : la ou il doit etre deplace
     */
    public void bougerPokemon(String nom,ArrayList<Pokemon> depart, ArrayList<Pokemon> arrivee ){
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
     * Verifie qu'un pokemon existe dans une liste à partir de son nom
     * @param nom : le nom du pokemon
     * @param liste : la liste dans laquelle on veut cherchee
     * @return true s'il est dans la liste, false sinon
     */
    public static boolean pokemonExiste(String nom,ArrayList<Pokemon> liste){
        for (Pokemon p:liste
        ) {
            if (nom.equals(p.getNom())){
                return true;
            }
        }
        return false;
    }

    /**
     * Détermine si le joueur a perdu la partie
     * @return true s'il a perdu, false sinon
     */
    public boolean aPerdu(){
        if (m_pioche.isEmpty()){
            if (m_main.isEmpty()){
                return m_terrain.isEmpty();
            }
        }
        return false;
    }

    /**
     * @return le pseudo du joueur
     */
    public String getPseudo()
    {
        return m_pseudo;
    }

    /**
     * @return la liste de pokemons dans la main du joueur
     */
    public ArrayList<Pokemon> getMain()
    {
        return m_main;
    }

    /**
     * @return la liste de pokemons dans la pioche du joueur
     */
    public ArrayList<Pokemon> getPioche()
    {
        return m_pioche;
    }

    /**
     * @return la liste de pokemons dans le terrain du joueur
     */
    public ArrayList<Pokemon> getTerrain()
    {
        return m_terrain;
    }

    /**
     * @return la liste de pokemons dans la defausse du joueur
     */
    public ArrayList<Pokemon> getDefausse()
    {
        return m_defausse;
    }

    @Override
    public String toString(){
        return "joueur "+m_pseudo;
    }
}
