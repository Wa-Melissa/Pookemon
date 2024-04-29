package Gestion_Jeu;

import Create_Pokemon.Pokemon;
import Gestion_Jeu.Joueur;

import java.util.ArrayList;

public class Plateau
{
    private String m_carte;
    private String m_separation = "===============================================================";
    private String m_affichage;

    public Plateau()
    {
        m_affichage = "";
    }

    /**
     * Méthode afficherPlateau : Affiche le plateau sur la console
     * @param J1 : Joueur 1
     * @param J2 : Joueur 2
     * @return m_affichage : Chaine de caractères contenant l'affichage du plateau
     */

    public String afficherPlateau(Joueur J1, Joueur J2)
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

        m_affichage += afficherCarte(J1);
        m_affichage += "\n" + m_separation + "\n";

        m_affichage += afficherCarte(J2) + "\n\n";
        m_affichage += afficherMain(J2);


        return m_affichage;
    }

    /**
     * Méthode afficherCarte() : Affiche les cartes sur le terrain d'un joueur
     * @param j : joueur dont les cartes sur le terrain vont être affichées
     * @return s : Chaîne de caractère contenant les cartes sur le terrain du joueur j
     */

    public String afficherCarte(Joueur j)
    {
        String s = "";
        for(Pokemon pokemon : j.m_terrain)
        {
            String[][] carte = {
                    {"Attaque: " + pokemon.getAttaque() , "Vie: " + pokemon.getPV(), "Affinite : " + pokemon.getElement().getElement(), pokemon.getNom()},
            };
            s += "--------------------\n";
            for (int i = 0; i < carte.length; i++) {
                String[] row = carte[i];
                s += String.format("| %-16s |\n| %-16s |\n| %-16s |\n| %-16s |\n", row[0], row[1], row[2], row[3]);
                s += "--------------------\n";
            }
        }

        return s;

    }

    /**
     * Méthode afficherMain() : Affiche la main du joueur en paramètre
     * @param j : le joueur qui doit afficher sa main
     * @return s : Chaîne de caractère contenant la main du joueur
     */

    public String afficherMain(Joueur j)
    {
        String s = "En main : \n";
        for (Pokemon pokemon : j.m_main)
        {
            s += "- " + pokemon.getNom() + ", " + pokemon.getElement().getElement() + ", Vie : " + pokemon.getPV() + ", Attaque : " + pokemon.getAttaque() + "\n";
        }
        return s;
    }
}