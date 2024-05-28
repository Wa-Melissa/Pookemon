package Affichage;

import Create_Pokemon.Pokemon;
import Players.Joueur;
import Players.Ordinateur;

import java.util.ArrayList;

public class Affichage_Plateau
{
    int m_tour = 1;
    private final String m_separation = "===========================================================================================================================";
    private String m_affichage;
    public static ArrayList<String> m_resume = new ArrayList<>(); //PROBLEME : on peut pas mettre des attributs en public


    public Affichage_Plateau()
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
        String Affichagetour = "Tour " + m_tour; // Affiche le Tour actuel

        if (J1.getClass() != Ordinateur.class)//Vérifie et corrige pour que le joueur en bas soit toujours l'utilisateur
        {
            Joueur temp = J1;
            J1 = J2;
            J2 = temp;
        }

        m_affichage = "\u001B[34m" + m_separation + "\n" + "\u001B[0m";
        m_affichage += creationEspacement(m_separation.length(),Affichagetour.length());

        m_affichage += "\u001B[34m" + Affichagetour +"\n" + m_separation + "\n" +"\u001B[0m" ;



        m_affichage += m_separation + "\n";
        m_affichage += creationEspacement(m_separation.length(),J1.getPseudo().length());

        m_affichage += "\u001B[33m" + J1.getPseudo() +"\n\n\n" + "\u001B[0m" +
                "pioche : " + J1.getPioche().size() + " Pokémons \n" +
                "defausse : " + J1.getDefausse().size() + " Cartes \n";
        m_affichage += afficherCarte(J1);


        m_affichage += "\n" + m_separation + "\n";
        m_affichage += creationEspacement(m_separation.length(),J2.getPseudo().length());

        m_affichage += "\u001B[33m" + J2.getPseudo() +"\n\n\n" + "\u001B[0m";
        m_affichage += afficherCarte(J2) + "\n";


        return m_affichage;
    }

    /**
     * Méthode creationEspacement() : créer des espaces avant certain texte pour les centrer
     * @param textRef : Texte de référence pour le centrage
     * @param textMid : texte à centrer
     * @return s : Chaîne de caractère contenant les espaces nécessaires pour centrer
     */

    public String creationEspacement(int textRef, int textMid)
    {
        String s ="";
        for(int i = 0; i < (textRef - textMid)/2; i++)
        {
            s += " ";
        }
        return s;
    }

    /**
     * Méthode afficherCarte() : Affiche les cartes sur le terrain d'un joueur
     * @param j : joueur dont les cartes sur le terrain vont être affichées
     * @return s : Chaîne de caractère contenant les cartes sur le terrain du joueur j
     */

    public String afficherCarte(Joueur j)
    {
        ArrayList<String> carteList = new ArrayList<>();

        String carteString = separation(j);

        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-33s |      ", pokemon.getNom());
        }
        carteString += "\n";
        carteString += separation(j);
        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-33s |      ", "Attaque: " + pokemon.getAttaque());
        }
        carteString += "\n";
        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-33s |      ", "Vie: " + pokemon.getPV() + "/" + pokemon.getPVMax());
        }
        carteString += "\n";
        for(Pokemon pokemon : j.getTerrain())
        {
            if (pokemon.getElement().getElement() == "Terre")
            {
                carteString += String.format("| %-42s |      ", "Affinite : " + pokemon.getElement().getElement());
            }
            carteString += String.format("| %-42s |      ", "Affinite : " + pokemon.getElement().getElement());
        }
        carteString += "\n";
        carteString += separation(j);
        for(Pokemon pokemon : j.getTerrain())
        {
            if(pokemon.getPower() == null)
            {
                carteString += String.format("| %-33s |      ", "Pouvoir : -----");
            } else
            {
                carteString += String.format("| %-33s |      ", "Pouvoir : " + pokemon.getPower().getNom());
            }

        }
        carteString += "\n";
        carteString += separation(j);
        carteList.add(carteString);


        return String.join("", carteList);
    }

    /**
     * Méthode separation() : Gere la séparation des informations de la carte pokémon
     * @param j : joueur dont les cartes sur le terrain vont être affichées
     * @return s : Chaîne de caractère contenant les séparations
     */

    public String separation(Joueur j)
    {
        String s = "";
        for(Pokemon pokemon : j.getTerrain())
        {
            s += "-------------------------------------      ";
        }
        s += "\n";
        return s;
    }

    /**
     * Méthode PertePokemon() : Affiche un texte lorsque l'un des deux joueurs perd un pokemon
     * @param j : utilisateur
     * @return s : Chaîne de caractère contenant l'annonce de la mort du Pokémon
     */

    public String PertePokemon(Joueur j)
    {
        String s = "";
        if (j.getClass() != Ordinateur.class)
        {
            s = "\u001B[31m" + "Oh mince ! tu as perdu un Pokémon...\n" + "\u001B[0m";
        } else
        {
            s = "\u001B[31m" + "Tu as éliminé un Pokémon ennemi ! Bien joué !" + "\u001B[0m";
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
        for (Pokemon pokemon : j.getMain())
        {
            String pouvoir = "Aucun";
            if (pokemon.getPower() != null){
                pouvoir = pouvoir.replaceFirst(pouvoir,pokemon.getPower().getNom());
            }
            s += "- " + "\u001B[1m" + pokemon.getNom() + "\u001B[0m" + ", ";
            s += pokemon.getElement().getElement() + ", ";
            s += "Vie : " + "\u001B[32m" + pokemon.getPV() + "\u001B[0m" + ", ";
            s += "Attaque : " + "\u001B[31m" + pokemon.getAttaque() + "\u001B[0m" + ", ";
            s += "Pouvoir: "+pouvoir+"\n";
        }
        return s;
    }

    public static void resumeTour(Pokemon attaquant, Pokemon cible)
    {
        if (m_resume.size() == 4)
        {
            m_resume.clear();
        }

        if (m_resume.isEmpty())
        {
            m_resume.add("\u001B[33m" +"           L'adversaire à jouer ! Voici ce qu'il a fait :           " + "\u001B[0m");
        }

        int degats = 0;

        String element = cible.getElement().getElement();

        if (attaquant.getElement().getAvantage() == element)
        {
            degats = attaquant.getAttaque() + 10;
        } else if (attaquant.getElement().getDesavantage() == element)
        {
            degats = attaquant.getAttaque() - 10;
        } else
        {
            degats = attaquant.getAttaque();
        }

        m_resume.add("- Son " + attaquant.getNom() + " a infligé " + degats + " dégats à ton " + cible.getNom());
    }

    public String AfficheResume()
    {
        String concat = "";
        String bordure = "*----------------------------------------------------------------------*";
        concat += creationEspacement(bordure.length(), "Résumé".length());
        concat += creationEspacement(m_separation.length(), bordure.length());
        concat += "Résumé\n";
        concat += creationEspacement(m_separation.length(), bordure.length());
        concat += bordure + "\n";
        for (String s : m_resume)
        {
            concat += creationEspacement(m_separation.length(), bordure.length());
            concat += String.format("| %-68s |      ", s) + "\n";
        }
        concat += creationEspacement(m_separation.length(), bordure.length());
        concat += bordure + "\n\n";

        return concat;
    }

    public void ajouterTour()
    {
        m_tour++;
    }
}