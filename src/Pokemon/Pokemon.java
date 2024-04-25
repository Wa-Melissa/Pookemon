package Pokemon;

import Pokemon.Element;

import java.util.concurrent.ThreadLocalRandom;
public class Pokemon
{
    private String m_nom;
    private int m_pv;
    private int m_attaque;
    private Element m_element;

    public Pokemon(){
        m_nom = Initialisation.getNom(); //Méthode statique ?
        m_pv = ThreadLocalRandom.current().nextInt(10, 21) * 10; //multiple de 10 entre 100 et 200
        m_attaque = ThreadLocalRandom.current().nextInt(1, 5) * 10;//multiple de 10 entre 10 et 40
        int nomElement = ThreadLocalRandom.current().nextInt(0,4);
        switch (nomElement){
            case 0: m_element = new Element("Eau");break;
            case 1: m_element = new Element("Feu");break;
            case 2: m_element = new Element("Air");break;
            default : m_element = new Element("Terre");
        }
    }

    public String getNom(){
        return m_nom;
    }

    public void attaque(Pokemon autre){
        if(m_element.m_avantage == autre.m_element.getElement()){
            autre.m_pv -= (m_attaque+10);
        } else if (m_element.m_desavantage == autre.m_element.getElement()){
            autre.m_pv -= (m_attaque-10);
        }
        else {autre.m_pv -= m_attaque;}
    }

    @Override
    public String toString(){
        return "nom:"+m_nom+"\nelement:"+m_element.getElement()+"\npv:"+m_pv+"\nattaque:"+m_attaque;
    }

    public static void main(String args[])
    {
        System.out.println("Lancement du jeu ...");
    }
}