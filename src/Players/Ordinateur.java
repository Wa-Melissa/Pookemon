package Players;

import Create_Pokemon.Element;
import Create_Pokemon.ActionsJoueur;
import Create_Pokemon.Pokemon;
import Affichage.Affichage_Plateau;

import java.util.ArrayList;
import java.util.Random;

public class Ordinateur extends Joueur implements ActionsJoueur {

    /**
     * cree un ordinateur
     * @param pseudo : le pseudo donné à l'ordinateur
     * @param commence : vrai si l'ordi commence, faux sinon, doit etre different de l'attribut du joueur
     */
    public Ordinateur(String pseudo, boolean commence){
        super(pseudo,commence);
    }

    /**
     * Place les pokemons dans l'ordre de sa main
     */
    @Override
    public void placerPokemon(){
        while(m_terrain.size()<3){
            m_terrain.add(m_main.remove(0));
        }
    }

    /**
     * Lance les attaque de ses pokemons, en séléctionnant automatiquement la cible
     * @param adversaire : Joueur ou Ordinateur qu'on attaque
     */
    @Override
    public void attaquePokemon(Joueur adversaire){
        //Les pokemons attaquent dans l'ordre du terrain, et s'il reste des pokemons en face à attaquer
        for (int i = 0 ; i < m_terrain.size() && !adversaire.m_terrain.isEmpty() ; i++){
            //On commence par selectionner les pokemons avec les meilleurs éléments
            Pokemon pokemonAttaquant = m_terrain.get(i);
            ArrayList<Pokemon> pokemonsCibles = (ArrayList<Pokemon>) adversaire.m_terrain.clone();
            Element elementPokemonAttaquant = pokemonAttaquant.getElement();
            pokemonsCibles = recuperePokemonsAvantageux(pokemonsCibles, elementPokemonAttaquant);

            Pokemon cible;
            //S'il y en a plusieurs, on récupère celui avec le moins de PV
            if(pokemonsCibles.size()>1){
                pokemonsCibles = getPokemonsPvMin(pokemonsCibles);

                //S'il y en a plusieurs, on en prend un au hasard
                if (pokemonsCibles.size() > 1) {
                    Random rdt = new Random();
                    cible = pokemonsCibles.remove(rdt.nextInt(pokemonsCibles.size()));
                } else{ cible = pokemonsCibles.get(0); }
            }else { cible = pokemonsCibles.get(0);}

            pokemonAttaquant.attaque(cible,adversaire);
            Affichage_Plateau.resumeTour(pokemonAttaquant,cible);
        }
        finirPouvoir();
    }

    /**
     * permet d'utiliser tous les pouvoirs du terrain de l'ordi
     * @param adv, l'adversaire du joueur
     */
@Override
    public void utiliserPouvoir( Joueur adv){
    ArrayList<Pokemon> attaquants = (ArrayList<Pokemon>) m_terrain.clone();
    for (Pokemon p :attaquants ) {
            if (p.possedePouvoir()){
                if (p.getPower().isUtilisable()){
                    p.getPower().utiliserPouvoir(this, adv);
                }
                else {
                    p.getPower().finEffetPouvoir();
                }
            }
        }
    }

    /**
     * recupere l'autorisation du joueur d'activer un pouvoir
     * @return true si le joueur est d'accord, false sinon
     */
    @Override
    public boolean autoriserPouvoir(){
        return true;
    }

    /**
     * Choisi un pokemon parmi une liste
     * @param zoneRecherche, la liste de pokemons parmi laquelle le joueur doit choisir
     * @param complementPhrase, string completant la question pour le joueur
     * @return le pokemon choisi
     */
    @Override
    public Pokemon trouverPokemon( ArrayList<Pokemon> zoneRecherche, String complementPhrase){
        Random rdt = new Random();
        return zoneRecherche.get(rdt.nextInt(zoneRecherche.size()));
    }

    /**
     * Donne les pokemons qui ont le moins de pv parmi une liste de depart
     * @param listeDep la liste de départ de pokemons, non vide
     * @return le ou les pokemon(s) qui ont le moins de pv
     */
    private ArrayList<Pokemon> getPokemonsPvMin(ArrayList<Pokemon> listeDep){
        //On initialise le minimum au pv du premier de la liste
        int pv_min = listeDep.get(0).getPV();
        ArrayList<Pokemon> pokemonsCibles = new ArrayList<>(); //liste des pokemons avec le minimum de pv
        pokemonsCibles.add(listeDep.get(0)); //Comme il donc les pv minimum, on ajoute le premier a la liste
        for (int j = 1 ; j < listeDep.size() ; j++){
            Pokemon pokemon = listeDep.get(j);
            int pv_pokemon = pokemon.getPV();
            if ( pv_pokemon < pv_min) { //Si un pokemon a moins de pv que le minimum, on met le minimum a jour et recommence la liste
                pv_min = pv_pokemon;
                pokemonsCibles.clear();
                pokemonsCibles.add(pokemon);
            }
            else if (pv_pokemon == pv_min){
                pokemonsCibles.add(pokemon);
            }
        }
        return pokemonsCibles;
    }

    /**
     * donne à partir d'une liste la liste des pokemons du terrain adverse qui ont l'element le plus avantageux possible
     * @param ttPokemonsAdverses la liste des pokemons du terrain adverse
     * @param monElement l'element du pokemon qui attaque
     * @return la liste de pokemons correspondante, ne renvoie pas de liste vide tant que la liste de depart n'est pas vide
     */
    private ArrayList<Pokemon> recuperePokemonsAvantageux(ArrayList<Pokemon> ttPokemonsAdverses, Element monElement){
        //Pour chaque attaque, on recupere la liste des pokemons contre lesquels on est avantagé
        String monAvantage = monElement.getAvantage();
        ArrayList<Pokemon> pokemonsCibles = getPokemonsAvecElement(ttPokemonsAdverses, monAvantage);

        if (pokemonsCibles.isEmpty()) {
            // S'il n'y en a aucun on recupere la liste des pokemons contre lesquels on n'est pas désavantagé
            pokemonsCibles = getPokemonsAvecElement(ttPokemonsAdverses, monElement.getElement()); //On commence par recuperer les pokemons de mon element
            String autreElementNeutre = new Element(monAvantage).getAvantage();
            pokemonsCibles.addAll(getPokemonsAvecElement(ttPokemonsAdverses, autreElementNeutre)); //Puis on ajoute les pokemons de l'element oposé sur la roue des éléments (l'avantage de l'avantage)

            if (pokemonsCibles.isEmpty()) {
                //S'il n'y en a aucun on recupere tous les pokemons adverses (contre lesquels on est desavantages)
                pokemonsCibles = ttPokemonsAdverses;
            }
        }
        return pokemonsCibles;
    }

    /**
     * Donne a partir d'une liste initiale la liste des pokemons qui possede un element en particulier
     * @param pokemonsAttaques la liste des pokemons que l'on peut attaquer
     * @param elementVoulu l'element en particulier que l'on veut que le pokemon ai
     * @return la liste des pokemons qui possèdent cet element, une liste vide s'il n'y en a aucun
     */
    private ArrayList<Pokemon> getPokemonsAvecElement(ArrayList<Pokemon> pokemonsAttaques, String elementVoulu){
        ArrayList<Pokemon> cibles = new ArrayList<>();
        for (Pokemon pokemonsAttaque : pokemonsAttaques) {
            if (elementVoulu.equals(pokemonsAttaque.getElement().getElement())) {
                cibles.add(pokemonsAttaque);
            }

        }
        return cibles;
    }


}
