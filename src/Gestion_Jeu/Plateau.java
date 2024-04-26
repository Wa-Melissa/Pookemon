package Gestion_Jeu;

import Create_Pokemon.Pokemon;
import Gestion_Jeu.Joueur;

public class Plateau
{
    private String m_carte;
    private String m_separation = "===============================================================";
    private String m_affichage;

    public Plateau()
    {
        m_affichage = "";
    }

    public String afficherPlateau(Joueur J1, Joueur J2, Pokemon pokemon)
    {
        m_affichage = m_separation + "\n" + "Tour 1 \n";
        for(int i = 0; i < 28; i++)
        {
            m_affichage += " ";
        }
        m_affichage += "Joueur 1\n";
        m_affichage += m_separation + "\n";
        for(int i = 0; i < 28; i++)
        {
            m_affichage += " ";
        }
        m_affichage += "Joueur 2\n\n\n" +
                "pioche : " + J1.m_pioche.toArray().length + " Pokémons \n" +
                "defausse : " + J1.m_defausse.toArray().length + " Cartes \n";



        return m_affichage;
    }

    public void afficherCarte(Pokemon pokemon)
    {
        String[][] carte = {
                {"Attaque: " + pokemon.getAttaque() , "Vie: " + pokemon.getPV(), "Affinite : " + pokemon.getElement().getElement(), pokemon.getNom()},
        };
        System.out.println("-------------------");
        for (int i = 0; i < carte.length; i++) {
            String[] row = carte[i];
            System.out.printf("| %-15s |\n| %-15s |\n| %-15s |\n| %-15s |\n", row[0], row[1], row[2], row[3]);
            System.out.println("-------------------");
        }


    }
}
