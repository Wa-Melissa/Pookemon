package Gestion_Jeu;

import Create_Pokemon.Pokemon;

import java.util.ArrayList;

public class Joueur extends Pokemon
{
    protected int m_num;

    protected String m_pseudo;

    protected ArrayList<Pokemon> m_pioche = new ArrayList<>();
    protected ArrayList<Pokemon> m_main;
    protected ArrayList<Pokemon> m_defausse = new ArrayList<>();
    protected ArrayList<Pokemon> m_terrain ;

    public Joueur(String pseudo, int ordrePassage)
    {
        m_pseudo = pseudo;
        m_num = ordrePassage;
        m_terrain = new ArrayList<>(3);
        for (int i = 0; i < 3; i++) {
            m_terrain.add(new Pokemon());
        }
        m_main = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            m_main.add(new Pokemon());
        }
    }
    public void piocher()
    {

    }

    public void placerPokemon()
    {

    }

    public String afficherJoueur()
    {
        return "Pseudo : " + m_pseudo + " Ordre de passage : " + m_num;
    }
}
