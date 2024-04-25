public class Element
{
    private String m_avantage;

    private String m_desavantage;

    private String m_nom;

    public Element(String nom, String avantage, String desavantage)
    {
        m_nom = nom;
        m_avantage = avantage;
        m_desavantage = desavantage;
    }

    public String getElement()
    {
        return m_nom;
    }
}
