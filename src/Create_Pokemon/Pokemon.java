package Create_Pokemon;

import Gestion_Jeu.Joueur;

import java.util.concurrent.ThreadLocalRandom;
public class Pokemon
{
    protected String m_nom;
    protected int m_pv;
    protected int m_attaque;

    protected Element m_element;

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
    public Element getElement() {
        return m_element;
    }
    public int getAttaque(){
        return m_attaque;
    }
    public int getPV(){
        return m_pv;
    }

    public void attaque(Pokemon autre, Joueur dresseurAutre){
        if(m_element.m_avantage.equals(autre.m_element.getElement())){
            autre.m_pv -= (m_attaque+10);
        } else if (m_element.m_desavantage.equals(autre.m_element.getElement())){
            autre.m_pv -= (m_attaque-10);
        }
        else {autre.m_pv -= m_attaque;}

        if (autre.m_pv <= 0){
            dresseurAutre.perdPokemon(autre);
        }
    }

    @Override
    public String toString()
    {
        return "Nom : "+ m_nom + "\nType : " + m_element.getElement() + "\nPV : " + m_pv + "\nAttaque : " + m_attaque;
    }

}