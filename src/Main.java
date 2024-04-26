import Create_Pokemon.Pokemon;

public class Main
{
    public static void main(String[] args)
    {
       Joueur j1 = new Joueur("nomUn",1);
       j1.piocher();
       j1.placerPokemon();
       j1.afficherJoueur();

    }
}
