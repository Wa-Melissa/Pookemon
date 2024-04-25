import Pokemon.Pokemon;

public class Main
{
    public static void main(String[] args)
    {
        Pokemon pokemon = new Pokemon();
        System.out.println("Lancement du jeu ...");
        System.out.println(pokemon.toString());

        Pokemon deux = new Pokemon();
        System.out.println(deux.toString());

    }
}
