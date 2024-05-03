package Gestion_Jeu;

import Create_Pokemon.Element;
import Create_Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Random;

public class Ordinateur extends Joueur {
    /**
     * cree un ordinateur avec un pseudo automatique
     * @param commence : vrai si l'ordi commence, faux sinon, doit être différent de l'attribut du joueur
     */
    public Ordinateur(boolean commence){
        super("Ordianteur",commence);
    }

    /**
     * cree un ordinateur
     * @param pseudo : le pseudo donné à l'ordinateur
     * @param commence : vrai si l'ordi commence, faux sinon, doit être différent de l'attribut du joueur
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

    //Ajouter tests terrain pas vide
    @Override
    public void attaquePokemon(Joueur adversaire){
        for (int i = 0 ; i < 3 ; i++){
            Pokemon pokemonAttaquant = m_terrain.get(i);
            ArrayList<Pokemon> pokemonsCibles = (ArrayList<Pokemon>) adversaire.m_terrain.clone();
            Element elementPokemonAttaquant = pokemonAttaquant.getElement();
            pokemonsCibles = recuperePokemonsAvantageux(pokemonsCibles, elementPokemonAttaquant);

            Pokemon cible;
            if(pokemonsCibles.size()>1){
                pokemonsCibles = getPokemonsPvMin(pokemonsCibles);
                if (pokemonsCibles.size() > 1) {
                    Random rdt = new Random();
                    cible = pokemonsCibles.remove(rdt.nextInt(pokemonsCibles.size()));
                } else{
                    cible = pokemonsCibles.get(0); }
            }else {
                cible = pokemonsCibles.get(0);
            }

            pokemonAttaquant.attaque(cible,adversaire);
        }
    }

    private ArrayList<Pokemon> getPokemonsPvMin(ArrayList<Pokemon> listeDep){
        int pv_min = listeDep.get(0).getPV();
        ArrayList<Pokemon> pokemonsCibles = new ArrayList<>();
        pokemonsCibles.add(listeDep.get(0));
        for (int j = 1 ; j < listeDep.size() ; j++){
            int pv_pokemon = listeDep.get(j).getPV();
            if ( pv_pokemon < pv_min) {
                pv_min = pv_pokemon;
                pokemonsCibles.clear();
                pokemonsCibles.add(listeDep.get(j));
            }
            else if (pv_pokemon == pv_min){
                pokemonsCibles.add(listeDep.get(j));
            }
        }
        return pokemonsCibles;
    }

    private ArrayList<Pokemon> recuperePokemonsAvantageux(ArrayList<Pokemon> ttPokemonsAdverses, Element monElement){
        //Pour chaque attaque, on recupere la liste des pokemons contre lesquels on est avantagé
        ArrayList<Pokemon> pokemonsCibles = getPokemonsAvecElement(ttPokemonsAdverses, monElement.getAvantage());

        if (pokemonsCibles.isEmpty()){
            // S'il n'y en a aucun on recupere la liste des pokemons contre lesquels on n'est pas désavantagé
            pokemonsCibles = getPokemonsAvecElement(ttPokemonsAdverses, monElement.getElement());
            String autreElementNeutre = new Element(monElement.getAvantage()).getAvantage();
            pokemonsCibles.addAll(getPokemonsAvecElement(ttPokemonsAdverses, autreElementNeutre));

            if (pokemonsCibles.isEmpty()){
                //S'il n'y en a aucun on recupere tous les pokemons adverses;
                pokemonsCibles = ttPokemonsAdverses;
            }
        }
        return pokemonsCibles;
    }

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
