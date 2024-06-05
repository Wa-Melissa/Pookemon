package Create_Pokemon;

import java.util.ArrayList;

public interface ActionsJoueur {

    /**
     * recupere l'autorisation du joueur d'activer un pouvoir
     * @return true si le joueur veut l'utiliser, false sinon
     */
     boolean autoriserPouvoir();


    /**
     * Trouve un pokemon choisi par le joueur
     * @param zoneRecherche, la liste de pokemons parmi laquelle le joueur doit choisir
     * @param complementPhrase, string completant la question pour le joueur
     * @return le pokemon choisi
     */
     Pokemon trouverPokemon(ArrayList<Pokemon> zoneRecherche, String complementPhrase);


    /**
     * Retire un pokemon du terrain et le place dans la defausse
     * @param p : Pokemon, doit etre sur le terrain
     */
    void perdPokemon(Pokemon p);

    /**
     * Recupere le contenu de la main du joueur
     * @return la liste des pokemons dans la main du joueur
     */
     ArrayList<Pokemon> getMain();

    /**
     * Recupere les pokemons qui sont sur le terrain du joueur
     * @return la liste des pokemons dans le terrain du joueur
     */
     ArrayList<Pokemon> getTerrain();
}
