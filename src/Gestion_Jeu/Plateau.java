package Gestion_Jeu;

public class Plateau
{
    private String m_carte;
    private String m_separation = "===============================================================";
    private String m_affichage;

    public Plateau()
    {
        m_affichage = "";
    }

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

        return m_affichage;
    }
}
