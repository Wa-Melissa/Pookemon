package Create_Pokemon;

public class Element
{
    protected String m_avantage;

    protected String m_desavantage;

    protected String m_nom;

    /**
     * Constructeur Element() : Crée les affinités d'un élément
     * @param nom : nom de l'élément
     */

    public Element(String nom)
    {
        m_nom = nom;
        switch (m_nom) {
            case "Eau": m_avantage = "Feu"; m_desavantage = "Terre"; break;
            case "Feu": m_avantage = "Air"; m_desavantage = "Eau"; break;
            case "Terre": m_avantage = "Eau"; m_desavantage = "Air"; break;
            case "Air": m_avantage = "Terre"; m_desavantage = "Feu"; break;
        }

    }

    public String getElement()
    {
        return m_nom;
    }

    public String getAvantage()
    {
        return m_avantage;
    }

}
