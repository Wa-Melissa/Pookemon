package Create_Pokemon;

public interface InfoCible {

    /**
     * soigne le pokemon sans dépasser ses pv max
     * @param soin int le nombre de pv à lui rendre
     */
    void estSoigne(int soin);


    /**
     * Méthode getNom() : Affiche le nom du Pokémon
     * @return m_nom : nom du Pokémon
     */
     String getNom();


    /**
     * Méthode getAttaque() : Affiche les dégats d'attaque du Pokémon
     * @return m_attaque : Attaque du Pokémon
     */
    int getAttaque();
}
