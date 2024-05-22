package Players;

import Create_Pokemon.Pokemon;
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
        for (int i = 0 ; i<21 ; i++){
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
            m_main.add(m_pioche.remove(0)); //ou rdt.nextInt(m_pioche.size())
        }
    }

    /**
     * deplace les pokemons du choix du joueur de sa main vers son terrain
     */
    public void placerPokemon(){
        while(m_terrain.size()<3){
            String choix = choisirPokemon(m_main,"placer");
            bougerPokemon(choix,m_main,m_terrain);
        }
    }

    /**
     * attaque l'adversere une fois avec chaque pokemon du terrain, dans l'ordre du choix de l'utilisateur
     * @param adversaire : Joueur ou Ordinateur qu'on attaque
     */
    public void attaquePokemon(Joueur adversaire){
        ArrayList<Pokemon> attaquants = (ArrayList<Pokemon>) m_terrain.clone();
        for ( int i = 0 ; i<3 ; i++){
            String pokemonChoisi = choisirPokemon(attaquants,"jouer");
            int j = 0;
            while(!attaquants.get(j).getNom().equals(pokemonChoisi)){
                j++;
            }
            Pokemon monPokemon = (attaquants.remove(j));
            utiliserPouvoir(monPokemon);
            String pokemonAttaque = choisirPokemon(adversaire.m_terrain,"attaquer");
            j = 0;
            while(!adversaire.m_terrain.get(j).getNom().equals(pokemonAttaque)){
                j++;
            }
            Pokemon pokemonAdverse = (adversaire.m_terrain.get(j));
            monPokemon.attaque(pokemonAdverse, adversaire);
        }
    }

    public void utiliserPouvoir(Pokemon pokemon){
        if (pokemon.possedePouvoir()){
        }
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
     * Fait choisir à l'utilisateur un pokemon parmis une liste
     * @param liste : la liste des pokemons parmis lesquels il doit choisir
     * @return le nom du pokemon selectionne
     */
    private String choisirPokemon(ArrayList<Pokemon> liste, String complementPhrase){
        Scanner scanner = new Scanner(System.in);
        boolean choixValide = false;
        System.out.print("Quel pokemon voulez-vous "+complementPhrase+" ? ("+listeChoixPoke(liste)+"): ");
        String choix = scanner.nextLine();
        choixValide = pokemonExiste(choix,liste);
        while (!choixValide){
            System.out.println("\t--> Ce nom n'est pas valide, veuillez entrer un nom valide");
            System.out.print("Quel pokemon voulez-vous "+complementPhrase+" ? ("+listeChoixPoke(liste)+"): ");
            choix = scanner.nextLine();
            choixValide = pokemonExiste(choix,liste);
        }
        return choix;
    }

    /**
     * deplace un pokemon d'une liste à une autre à partir de son nom
     * @param nom : nom du pokemon a deplacer, doit etre dans dans depart
     * @param depart : la ou est actuellement le pokemon a deplacer
     * @param arrivee : la ou il doit etre deplace
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
     * fabrique la liste des noms des pokemons parmi lesquels l'utilisateur doit choisir
     * @param liste : liste des pokemons
     * @return la string contenant tous les noms
     */
    private String listeChoixPoke(ArrayList<Pokemon> liste){
        String s = "";
        for (Pokemon p:liste
        ) {
            s = s.concat(p.getNom()+"/");
        }
        s = s.substring(0,s.length()-1);
        return s;
    }

    /**
     * Verifie qu'un pokemon existe dans une liste à partir de son nom
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
     * Détermine si le joueur a perdu la partie
     * @return true s'il a perdu, false sinon
     */
    public boolean aPerdu(){
        if (m_pioche.isEmpty()){
            if (m_main.isEmpty()){
                if (m_terrain.isEmpty()){
                    return true;
                }
            }
        }
        return false;
    }

    public String getPseudo()
    {
        return m_pseudo;
    }

    public ArrayList<Pokemon> getMain()
    {
        return m_main;
    }

    public ArrayList<Pokemon> getPioche()
    {
        return m_pioche;
    }

    public ArrayList<Pokemon> getTerrain()
    {
        return m_terrain;
    }

    public ArrayList<Pokemon> getDefausse()
    {
        return m_defausse;
    }

}
