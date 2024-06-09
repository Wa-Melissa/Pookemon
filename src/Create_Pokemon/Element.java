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
                case "Eau":
                    m_avantage = "Feu";
                    m_desavantage = "Terre";
                    break;
                case "Feu":
                    m_avantage = "Air";
                    m_desavantage = "Eau";
                    break;
                case "Terre":
                    m_avantage = "Eau";
                    m_desavantage = "Air";
                    break;
                case "Air":
                    m_avantage = "Terre";
                    m_desavantage = "Feu";
                    break;
            }

    }

    /**
     * accesseur au nom de l'élément
     * @return m_nom le nom de l'élément
     */
    public String getElement()
    {
        switch (m_nom) {
            case "Feu":
                return "\u001B[31m" + m_nom + "\u001B[0m";

            case "Air":

                return "\u001B[33m" + m_nom + "\u001B[0m";

            case "Terre":

                return "\u001B[32m" + m_nom + "\u001B[0m";

            default:

                return "\u001B[34m" + m_nom + "\u001B[0m";
        }

    }

    /**
     * accesseur a l'avantage de l'elément
     * @return le nom de l'élément sur lequel cet élément à l'avantage
     */
    public String getAvantage()
    {
        return m_avantage;
    }

    /**
     * accesseur au desavantage de l'elément
     * @return le nom de l'élément sur lequel cet élément à un desavantage
     */
    public String getDesavantage()
    {
        return m_desavantage;
    }

    @Override
    public String toString(){
        return "élément "+m_nom;
    }

}
