
public class Plateau
{
    private String m_carte;
    private String m_separation = "===============================================================";
    private String m_affichage;

    public Plateau()
    {
        m_affichage = "";
    }

    public String afficherPlateau()
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
        m_affichage += "Joueur 2\n\n\n";
        m_affichage += "pioche : " + ;

        return m_affichage;
    }
}
