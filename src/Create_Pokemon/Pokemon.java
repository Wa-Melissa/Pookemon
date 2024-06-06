package Create_Pokemon;

import Players.Joueur;

import java.util.concurrent.ThreadLocalRandom;
public class Pokemon implements InfoCible
{
    String m_nom;
    int m_pvMax;
    int m_pv;
    int m_attaque;
    Power m_pouvoir;
    Element m_element;

    /**
     * Constructeur Pokemon() : Crée un pokemon avec un nom, un élément, des PV et des dégats d'attaque
     */
    public Pokemon(){
        m_nom = Initialisation.getNom(); //Méthode statique ?
        m_pvMax = ThreadLocalRandom.current().nextInt(10, 21) * 10; //multiple de 10 entre 100 et 200
        m_attaque = ThreadLocalRandom.current().nextInt(1, 5) * 10;//multiple de 10 entre 10 et 40
        m_pv = m_pvMax;
        int nomElement = ThreadLocalRandom.current().nextInt(0,4);
        switch (nomElement){
            case 0: m_element = new Element("Eau");break;
            case 1: m_element = new Element("Feu");break;
            case 2: m_element = new Element("Air");break;
            default : m_element = new Element("Terre");
        }
        int definitElus = ThreadLocalRandom.current().nextInt(0,5);
        if (definitElus == 1){
            String pouvoirDonne = Initialisation.getPouvoir();
            if (pouvoirDonne != null){
                switch (pouvoirDonne){
                    case "Berserk" : m_pouvoir = new Berserk();
                    case "Soin simple" : m_pouvoir = new SoinSimple();break;
                    case "Soin de zone" : m_pouvoir = new SoinZone() ; break;
                    case "Kamikaze" : m_pouvoir = new Kamikaze(this); break;
                    case "Régénération" : m_pouvoir = new Regeneration(); break;
                    case "Peur" : m_pouvoir = new Peur(); break;
                    case "Usurpation" : m_pouvoir = new Usurpation(this) ; break;
                    case "Extension du territoire": m_pouvoir = new ExtensionTerritoire(); break;
                    default: m_pouvoir = null;
                }
            } else {m_pouvoir = null;}
        } else {m_pouvoir = null;}
    }

    /**
     * Méthode getNom() : Affiche le nom du Pokémon
     * @return m_nom : nom du Pokémon
     */

    public String getNom(){
        return m_nom;
    }

    public Power getPower()
    {
        return m_pouvoir;
    }

    /**
     * Méthode getELement() : Affiche l'élément du Pokémon
     * @return m_element : Element du Pokemon
     */

    public Element getElement() {
        return m_element;
    }

    /**
     * Méthode getAttaque() : Affiche les dégats d'attaque du Pokémon
     * @return m_attaque : Attaque du Pokémon
     */

    public int getAttaque(){
        return m_attaque;
    }

    /**
     * soigne le pokemon sans dépasser ses pv max
     * @param soin int le nombre de pv à lui rendre
     */
    public void estSoigne(int soin) {
        if (m_pv + soin <= m_pvMax) {
            m_pv += soin;
        } else {
            m_pv = m_pvMax;
        }
    }


    /**
     * Méthode getPV() : Affiche les PV actuels du Pokémon
     * @return m_pv
     */

    public int getPV(){
        return m_pv;
    }

    /**
     * Méthode getPV() : Affiche les PV Max du Pokémon
     * @return m_pvMax
     */
    public int getPVMax(){return m_pvMax;}

    public boolean possedePouvoir(){
        return (m_pouvoir != null);
    }

    /**
     * Méthode attaque() : Permet de gérer l'action d'attaque d'un pokémon vers un autre
     * @param autre : Pokémon attaqué
     */
    public void attaque(Pokemon autre, Joueur dresseurAutre){
        int attaque;
        if(m_element.m_avantage.equals(autre.m_element.getElement())){
            attaque = m_attaque+10 ;
        } else if (m_element.m_desavantage.equals(autre.m_element.getElement())){
            attaque = m_attaque - 10;
        }
        else { attaque = m_attaque;}

        if (attaque > 0){ //On vérifie que l'attaque n'est pas négative
            autre.m_pv -= attaque;
        }

        if (autre.m_pv <= 0){
            dresseurAutre.perdPokemon(autre);
        }
    }


    /**
     * Méthode toString() : Renvoie les informations à propos du Pokémon
     * @return "Nom : ... Type : ... PV : ... Attaque : ..."
     */

    @Override
    public String toString()
    {
        return "Nom : "+ m_nom + "\nType : " + m_element.getElement() + "\nPV : " + m_pv + "\nAttaque : " + m_attaque;
    }

}