package Affichage;

import Create_Pokemon.Pokemon;
import Players.Joueur;
import Players.Ordinateur;

import java.util.ArrayList;

public class Affichage_Plateau
{

    /**
     * Initialisation des attributs
     */

    int m_tour = 1;
    private String m_separation = "";
    private String m_affichage;
    private static ArrayList<String> m_resume = new ArrayList<>();

    /**
     * Constructeur Affichage_Plateau : Crée un plateau
     */

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
        // Changement de la taille de l'affichage en fonction du nombre de cartes sur le terrain
        Joueur joueurPetitTerrain;
        if (J1.getTerrain().size() < J2.getTerrain().size())
        {
            joueurPetitTerrain = J2;
        } else
        {
            joueurPetitTerrain = J1;
        }
        m_separation = "";
        for (Pokemon carte : joueurPetitTerrain.getTerrain())
        {

            m_separation += "===========================================";
        }

            // Affiche le Tour actuel
            String Affichagetour = "Tour " + m_tour;

            // Vérifie et corrige pour que le joueur en bas soit toujours l'utilisateur
            if (J1.getClass() != Ordinateur.class)
            {
                Joueur temp = J1;
                J1 = J2;
                J2 = temp;
            }

            //Affichage du bandeau "Tour"
            m_affichage = "\u001B[34m" + m_separation + "\n" + "\u001B[0m";
            m_affichage += creationEspacement(m_separation.length(),Affichagetour.length());
            m_affichage += "\u001B[34m" + Affichagetour +"\n" + m_separation + "\n" +"\u001B[0m" ;

            //Affichage de la séparation et du nom de l'ordinateur
            m_affichage += m_separation + "\n";
            m_affichage += creationEspacement(m_separation.length(),J1.getPseudo().length());
            m_affichage += "\u001B[33m" + J1.getPseudo() + "\n\n\n" + "\u001B[0m";

            //Affichage du nombre de pokémon dans la pioche et dans la défausse de l'ordinateur
            m_affichage += "pioche : " + J1.getPioche().size() + " Pokémons \n" +
                    "defausse : " + J1.getDefausse().size() + " Cartes \n";

            //Affichage des cartes de l'ordinateur
            m_affichage += afficherCarte(J1);

            //Affichage de la séparation et du nom du Joueur
            m_affichage += "\n" + m_separation + "\n";
            m_affichage += creationEspacement(m_separation.length(),J2.getPseudo().length());
            m_affichage += "\u001B[33m" + J2.getPseudo() +"\n\n\n" + "\u001B[0m";

            //Affichage des cartes du Joueur
            m_affichage += afficherCarte(J2) + "\n";

        return m_affichage;
    }


    /**
     * Méthode creationEspacement() : créer des espaces avant certain texte pour les centrer
     * @param textRef : Texte de référence pour le centrage
     * @param textMid : texte à centrer
     * @return s : Chaîne de caractère contenant les espaces nécessaires pour centrer
     */

    private String creationEspacement(int textRef, int textMid)
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

    private String afficherCarte(Joueur j)
    {
        ArrayList<String> carteList = new ArrayList<>();

        String carteString = separation(j);

        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-34s |      ", pokemon.getNom());
        }
        carteString += "\n";
        carteString += separation(j);
        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-34s |      ", "Attaque: " + pokemon.getAttaque());
        }
        carteString += "\n";
        for(Pokemon pokemon : j.getTerrain())
        {
            carteString += String.format("| %-34s |      ", "Vie: " + pokemon.getPV() + "/" + pokemon.getPVMax());
        }
        carteString += "\n";
        for(Pokemon pokemon : j.getTerrain())
        {
            if (pokemon.getElement().getElement() == "Terre")
            {
                carteString += String.format("| %-43s |      ", "Affinite : " + pokemon.getElement().getElement());
            }
            carteString += String.format("| %-43s |      ", "Affinite : " + pokemon.getElement().getElement());
        }
        carteString += "\n";
        carteString += separation(j);
        for(Pokemon pokemon : j.getTerrain())
        {
            if(!(pokemon.getPower() == null))
            {
                if (pokemon.getPower().isUtilisable())
                {
                    carteString += String.format("| %-34s |      ", "Pouvoir : " + pokemon.getPower().getNom());
                } else
                {
                    carteString += String.format("| Pouvoir :\u001B[31m %-21s \u001B[0m |      ", "" + pokemon.getPower().getNom()) + "";
                }
            } else
            {
                carteString += String.format("| %-34s |      ", "Pouvoir : -----");
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

    private String separation(Joueur j)
    {
        String s = "";
        for(Pokemon pokemon : j.getTerrain())
        {
            s += "--------------------------------------      ";
        }
        s += "\n";
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

    /**
     * Méthode resumeTour : Crée le résumé du tour de l'adversaire
     * @param attaquant : Pokémon qui a attaqué
     * @param cible : Pokémon qui a reçu l'attaque
     */

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

        if (attaquant.getElement().getAvantage().equals(element))
        {
            degats = attaquant.getAttaque() + 10;
        } else if (attaquant.getElement().getDesavantage().equals(element))
        {
            degats = attaquant.getAttaque() - 10;
        } else
        {
            degats = attaquant.getAttaque();
        }

        m_resume.add("- Son " + attaquant.getNom() + " a infligé " + degats + " dégats à ton " + cible.getNom());
    }

    /**
     * Méthode AfficheResume : Affiche le résumé du tour de l'adversaire
     */

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

    /**
     * Méthode afficheDepart : Affiche le message de départ de la partie
     * @param J1
     */

    public static void afficheDepart(Joueur J1)
    {
        String separation = "";
        for (Pokemon carte : J1.getTerrain())
        {
            separation += "===========================================";

        }
        String goAffichage = "C'est parti !!";
        String espace = "";

        for(int i = 0; i < (separation.length() - goAffichage.length())/2; i++)
        {
            espace += " ";
        }
        String finale = "\u001B[32m" + separation + "\n" + separation + "\n" + espace + goAffichage + "\n"
                + separation + "\n" + separation + "\n" + "\u001B[0m";
        System.out.println(finale);
    }

    /**
     * Méthode ajouterTour : ajoute un tour au compteur
     */

    public void ajouterTour()
    {
        m_tour++;
    }
}